/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("restauranteModule");//Definicion del modulo que usaremos desde el app.js
    mod.constant("restaurantesContext", "api/sucursales");
    mod.controller('restauranteNewCtrl', ['$scope', '$http', 'restaurantesContext', '$state', '$rootScope',
        /*
        * Funcion para crear un nuevo restaurante a partir de los parametros definidos en el back
        */
        function ($scope, $http, restaurantesContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.createRestaurante = function () {
                $http.post(restaurantesContext, {
                    direccion: $scope.restauranteDireccion,
                    dosPisos: $scope.restauranteDosPisos,
                    calificacion: $scope.restauranteCalificacion,
                    image: $scope.restauranteImage1
                }).then(function (response) {
                    //restaurante created successfully
                    $state.go('restaurantesList', {restauranteId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(angular);