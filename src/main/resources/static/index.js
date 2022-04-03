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
       $http.post('http://localhost:8189/catmarket/api/v1/cart/' + id)
                    .then(function (response) {
                         $scope.fillCartTable();
                         });
    }

         $scope.fillCartTable = function () {
                $http.get('http://localhost:8189/catmarket/api/v1/cart')
                    .then(function (response) {
                    $scope.productsInCart = response.data;
                    });
            }
             $scope.fillCartTable();
    $scope.fillTable();
});