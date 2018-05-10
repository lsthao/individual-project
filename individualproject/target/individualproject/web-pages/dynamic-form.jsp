<script>
    $(document).ready(function() {

        $("#restaurant-name").change(function(){

            var value = $(this).val();

            if (value == "Add New") {

                var $newRestaurantDiv = $('<div id="new-restaurant"></div>');

                var $newRestaurantNameDiv = $('<div class="form-group"></div>');
                var $newRestaurantNameLabel = $('<label for="new-restaurant-name">Restaurant Name:</label>');
                var $newRestaurantNameInput = $('<input type="text" class="form-control" name="new-restaurant-name" id="new-restaurant-name">');

                $newRestaurantNameDiv.append($newRestaurantNameLabel);
                $newRestaurantNameDiv.append($newRestaurantNameInput);
                $newRestaurantDiv.append($newRestaurantNameDiv);

                var $streetAddressDiv = $('<div class="form-group"></div>');
                var $streetAddressLabel = $('<label for="street-address">Street Address:</label>');
                var $streetAddressInput = $('<input type="text" class="form-control" name="street-address" id="street-address">');

                $streetAddressDiv.append($streetAddressLabel);
                $streetAddressDiv.append($streetAddressInput);
                $newRestaurantDiv.append($streetAddressDiv);

                var $cityDiv = $('<div class="form-group"></div>');
                var $cityLabel = $('<label for="city">City:</label>');
                var $cityInput = $('<input type="text" class="form-control" id="city" name="city">');

                $cityDiv.append($cityLabel);
                $cityDiv.append($cityInput);
                $newRestaurantDiv.append($cityDiv);

                var $stateDiv = $('<div class="form-group"></div>');
                var $stateLabel = $('<label for="state">State:</label>');
                var $stateInput = $('<input type="text" class="form-control" id="state" name="state">');

                $stateDiv.append($stateLabel);
                $stateDiv.append($stateInput);
                $newRestaurantDiv.append($stateDiv);

                var $zipCodeDiv = $('<div class="form-group"></div>');
                var $zipCodeLabel = $('<label for="zip-code">Zip Code:</label>');
                var $zipCodeInput =  $('<input type="text" class="form-control" id="zip-code" name="zip-code">');

                $zipCodeDiv.append($zipCodeLabel);
                $zipCodeDiv.append($zipCodeInput);
                $newRestaurantDiv.append($zipCodeDiv);

                var $phoneDiv = $('<div class="form-group"></div>');
                var $phoneLabel = $('<label for="phone-number">Phone Number:</label>');
                var $phoneInput = $('<input type="text" class="form-control" id="phone-number" name="phone-number">');

                $phoneDiv.append($phoneLabel);
                $phoneDiv.append($phoneInput);
                $newRestaurantDiv.append($phoneDiv);

                $("#picture-form").append($newRestaurantDiv);

            } else {

                $("#new-restaurant").remove();

            }

            if (!$("#submitbutton").length) {
                var $submitbutton = $('<input type="submit">');
                $submitbutton.attr("id", "submitbutton");
                $("#picture-form").append($submitbutton);
            } else {
                $("#submitbutton").remove();
                var $submitbutton = $('<input type="submit">');
                $submitbutton.attr("id", "submitbutton");
                $("#picture-form").append($submitbutton);

            }



        });

    });
</script>