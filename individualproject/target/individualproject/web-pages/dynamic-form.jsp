<script>
    $(document).ready(function() {

        alert("test hello");

        $("#restaurant-name").change(function(){

            var value = $(this).val();

            if (value == "Add New") {
                var $streetAddressDiv = $('<div class="form-group"></div>');
                var $streetAddressLabel = $('<label for="street-address">Street Address:</label>');
                var $streetAddressInput = $('<input type="text" class="form-control" id="street-address">');

                $streetAddressDiv.append($streetAddressLabel);
                $streetAddressDiv.append($streetAddressInput);
                $("#picture-form").append($streetAddressDiv);

                var $cityDiv = $('<div class="form-group"></div>');
                var $cityLabel = $('<label for="city">City:</label>');
                var $cityInput = $('<input type="text" class="form-control" id="city">');

                $cityDiv.append($cityLabel);
                $cityDiv.append($cityInput);
                $("#picture-form").append($cityDiv);

                var $stateDiv = $('<div class="form-group"></div>');
                var $stateLabel = $('<label for="state">State:</label>');
                var $stateInput = $('<input type="text" class="form-control" id="state">');

                $stateDiv.append($stateLabel);
                $stateDiv.append($stateInput);
                $("#picture-form").append($stateDiv);

                var $zipCodeDiv = $('<div class="form-group"></div>');
                var $zipCodeLabel = $('<label for="zip-code">Zip Code:</label>');
                var $zipCodeInput =  $('<input type="text" class="form-control" id="zip-code">');

                $zipCodeDiv.append($zipCodeLabel);
                $zipCodeDiv.append($zipCodeInput);
                $("#picture-form").append($zipCodeDiv);

                var $websiteDiv = $('<div class="form-group"></div>');
                var $websiteLabel = $('<label for="website">Web Site:</label>');
                var $websiteInput = $('<input type="text" class="form-control" id="website">');

                $websiteDiv.append($websiteLabel);
                $websiteDiv.append($websiteInput);
                $("#picture-form").append($websiteDiv);

            }

            var $submitbutton = $('<input type="submit">');

            $("#picture-form").append($submitbutton);
        });


    });
</script>