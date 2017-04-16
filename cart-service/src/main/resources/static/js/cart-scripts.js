(function ($, Mustache) {
  'use strict';

  // Check if jQuery has been loaded in the page.
  if (!$) {
    console.error('Cart scripts require jQuery.');
    return;
  }
  // Check if Mustache has been loaded in the page.
  if (!Mustache) {
    console.error('Cart scripts require Mustache.');
    return;
  }

  // Define a variable to hold the public route for the cart service.
  // This route will be used as a URL prefix for all AJAX requests.
  var cartRoute = '';

  // Define a function to update the line item count elements by
  // loading the current value via AJAX from the cart service.
  var updateLineItemCount = function () {
    var lineItemCounts = $('.cart-js--line-item-count');
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
    $('.cart-js--add-line-item').click(function (event) {
      var productSeoName = $(event.currentTarget).data('product-seo-name');
      $.get(cartRoute + '/add/' + productSeoName).then(function (cart) {
        updateLineItemCount();
      }).catch(function (xhr, statusText) {
        console.error('Product with SEO name "' + productSeoName + '" could not be added to cart. Error: ', statusText);
      });
      event.preventDefault();
    });

    // Load the line item list if such an element is present in the page.
    // The line item data is loaded via AJAX from the cart service.
    // The template used to render the HTML is loaded via AJAX from the URL given in the data attribute.
    // Once both AJAX responses have been received the HTML output is rendered using Mustache.
    var lineItemLists = $('.cart-js--line-item-list');
    if (lineItemLists.length) {
      var lineItemDataPromise = $.get(cartRoute + '/view');
      lineItemLists.each(function () {
        var lineItemListElement = $(this);
        var templateURL = lineItemListElement.data('cart-js-template');
        $.when(lineItemDataPromise, $.get(templateURL)).then(function (data, template) {
          var lineItemList = Mustache.render(template[0], data[0]);
          lineItemListElement.html(lineItemList);
        }).catch(function (xhr, statusText) {
          console.error('Cart line item list could not be loaded. Error: ', statusText);
        });
      });
    }

    // Initialize the line item count elements.
    updateLineItemCount();
  });
})(typeof jQuery !== 'undefined' ? jQuery : undefined, typeof Mustache !== 'undefined' ? Mustache : undefined);
