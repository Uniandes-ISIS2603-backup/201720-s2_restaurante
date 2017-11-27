    /* * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("restauranteModule");//Definicion del modulo que usaremos desde el app.js
    
    mod.constant("restaurantesContext", "http://localhost:8080/restaurante-web/api/sucursales");
    mod.controller('restauranteDeleteCtrl', ['$scope', '$http', 'restaurantesContext', '$state',
        /*
         * Eliminamos un restaurante con id especificado por parametro
         * Param: restauranteId
         */
        function ($scope, $http, restaurantesContext, $state) {
             var idRestaurante = $state.params.restauranteId;
            $scope.deleteRestaurante = function () {
                $http.delete(restaurantesContext + '/' + idRestaurante, {}).then(function (response) {
                    $state.go('restaurantesList', {restauranteId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(angular);