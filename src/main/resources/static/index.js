angular.module('catmarket', []).controller('indexController', function ($scope, $http) {

    $scope.fillTable = function () {
        $http.get('http://localhost:8189/catmarket/api/v1/products')
            .then(function (response) {
            $scope.products = response.data;
            });
    };

    $scope.deleteProduct = function(id) {
     $http.delete('http://localhost:8189/catmarket/api/v1/products/' + id)
                .then(function (response) {
                     $scope.fillTable();
                     });
    }

    $scope.createNewProduct = function() {
       $http.post('http://localhost:8189/catmarket/api/v1/products', $scope.newProduct)
                .then(function (response) {
                $scope.newProduct = null;
                $scope.fillTable();
                });
    }

          $scope.addProductToCart = function(id) {
             $http.get('http://localhost:8189/catmarket/api/v1/cart/add/' + id)
                        .then(function (response) {
                             $scope.fillCartTable();
                             });
            }

                    $scope.deleteProductInCart = function(id) {
                         $http.delete('http://localhost:8189/catmarket/api/v1/cart/delete/' + id)
                                    .then(function (response) {
                                         $scope.fillCartTable();
                                         });
                        }



                  $scope.fillCartTable = function() {
                            $http.get('http://localhost:8189/catmarket/api/v1/cart')
                                      .then(function (response) {
                                      $scope.cartItems = response.data.items;
                                      $scope.totalPrice = response.data.totalPrice;
                                      });
                        }

        $scope.deleteAllItemsInCart = function() {
         $http.delete('http://localhost:8189/catmarket/api/v1/cart/deleteAll')
                    .then(function (response) {
                         $scope.fillCartTable();
                         });
        }



        $scope.userAuthService = function() {
        $http.post('http://localhost:8189/catmarket/auth', $scope.userAuth)
                    .then(function (response) {
//                             $scope.getMyEmail();
                                        $scope.token = response.data;
                        });
        }

   $scope.getMyEmail = function() {
        $http.get('http://localhost:8189/catmarket/auth/get_my_email')
                    .then(function (response) {
                          $scope.email = response.data;
                        });
        }

    $scope.fillCartTable();
    $scope.fillTable();
});