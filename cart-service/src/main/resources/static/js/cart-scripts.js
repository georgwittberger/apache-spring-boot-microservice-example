(function ($) {
  // Check if jQuery has been loaded in the page.
  if (typeof $ === 'undefined') {
    console.error('Cart scripts require jQuery.');
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
      $.get(cartRoute + '/count').done(function (count) {
        lineItemCounts.text(count);
      }).fail(function () {
        console.error('Cart line item count could not be loaded.');
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
    // This will fetch the product's SEO name from the data attribute and call
    // the cart service to add the product to the cart.
    $('.cart-js--add-line-item').click(function (event) {
      var productSeoName = $(event.currentTarget).data('product-seo-name');
      $.get(cartRoute + '/add/' + productSeoName).done(function (cart) {
        updateLineItemCount();
      }).fail(function () {
        console.error('Product with SEO name "' + productSeoName + '" could not be added to cart.');
      });
      event.preventDefault();
    });

    // Load the line item list if such an element is present in the page.
    var lineitemLists = $('.cart-js--line-item-list');
    if (lineitemLists.length) {
      $.get(cartRoute + '/view').done(function (list) {
        lineitemLists.html(list);
      }).fail(function () {
        console.error('Cart line item list could not be loaded.');
      });
    }

    // Initialize the line item count elements.
    updateLineItemCount();
  });
})(jQuery);
