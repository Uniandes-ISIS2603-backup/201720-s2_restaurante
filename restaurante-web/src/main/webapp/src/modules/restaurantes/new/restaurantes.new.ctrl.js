/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("restauranteModule");
    mod.constant("restaurantesContext", "api/restaurantes");
    mod.controller('restauranteNewCtrl', ['$scope', '$http', 'restaurantesContext', '$state', 'booksContext', '$rootScope',
        function ($scope, $http, restaurantesContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.createRestaurante = function () {
                $http.post(restaurantesContext, {
                    name: $scope.restauranteDireccion,
                    birthDate: $scope.restauranteDosPisos,
                    description: $scope.restauranteCalificacion,
                    image: $scope.restauranteImage
                }).then(function (response) {
                    //restaurante created successfully
                    $state.go('restaurantesList', {restauranteId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(angular);