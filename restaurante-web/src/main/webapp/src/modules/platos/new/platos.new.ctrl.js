/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("platoModule");
    mod.constant("platosContext", "http://localhost:8080/restaurante-web/api/platos");
    mod.controller('platoNewCtrl', ['$scope', '$http', 'platosContext', '$state', '$rootScope',
        function ($scope, $http, platosContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.createPlato = function () {
                $http.post(platosContext, {
                    name: $scope.platoName,
                    especialSucursal: $scope.platoEspecialSucursal,
                    precio: $scope.platoPrecio
                }).then(function (response) {
                    
                    $state.go('platosList', {platoId: response.data.id}, {reload: true});
                    var index = $scope.platosRecords.indexOf(response.data);
                    $scope.platosRecords.splice(index, 1);
                });
            };
        }
    ]);
}
)(window.angular);

