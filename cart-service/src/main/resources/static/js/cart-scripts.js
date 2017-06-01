(function ($) {
  'use strict';

  // Check if jQuery has been loaded in the page.
  if (!$) {
    console.error('Cart scripts require jQuery.');
    return;
  }

  // Define a variable to hold the public route for the cart service.
  // This route will be used as a URL prefix for all AJAX requests.
  var cartRoute = '';

  // Define a function to update the line item count elements by
  // loading the current value via AJAX from the cart service.
  var updateLineItemCount = function () {
    var lineItemCounts = $('.cart-js-line-item-count');
    if (lineItemCounts.length) {
      $.get(cartRoute + '/count').then(function (count) {
        lineItemCounts.text(count);
      }).catch(function (xhr, statusText) {
        console.error('Cart line item count could not be loaded. Error: ', statusText);
      });
    }
  };

  $(function () {
    // Get the public route for the cart service from the meta tag.
    var routeMetaData = $('meta[name="cartRoute"]');
    if (routeMetaData.length) {
      cartRoute = routeMetaData.attr('content');
    } else {
      console.warn('Cart route meta data not found.');
    }

    // Register an event handler for clicks on the "Add product to cart" links.
    // It will fetch the product's SEO name from the data attribute required on the link
    // and call the cart service via AJAX to add the product to the cart.
    $('.cart-js-add-line-item').click(function (event) {
      var productSeoName = $(event.currentTarget).data('product-seo-name');
      $.get(cartRoute + '/add/' + productSeoName).then(function (cart) {
        updateLineItemCount();
      }).catch(function (xhr, statusText) {
        console.error('Product with SEO name "' + productSeoName + '" could not be added to cart. Error: ', statusText);
      });
      event.preventDefault();
    });

    // Initialize the line item count elements.
    updateLineItemCount();
  });
})(typeof jQuery !== 'undefined' ? jQuery : undefined);
