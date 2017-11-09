    /* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("restauranteModule");
    mod.constant("restaurantesContext", "api/sucursales");
    mod.controller('restauranteDeleteCtrl', ['$scope', '$http', 'restaurantesContext', '$state',
        function ($scope, $http, restaurantesContext, $state) {
            $scope.deleteRestaurante = function () {
                $http.delete(restaurantesContext + '/' + idRestaurante, {}).then(function (response) {
                    $state.go('restaurantesList', {restauranteId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(angular);