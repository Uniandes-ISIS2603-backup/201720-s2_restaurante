/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("pedidoModule");
    mod.constant("pedidosContext", "api/pedidos");
    mod.controller('pedidoNewCtrl', ['$scope', '$http', 'pedidosContext', '$state', '$rootScope',
        function ($scope, $http, pedidosContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.createCliente = function () {
                $http.post(pedidosContext, {
                    nombre: $scope.pedidoNombre,
                    apellido: $scope.pedidoApellido,
                    direccion: $scope.pedidoDireccion,
                    numPuntos: $scope.pedidoNumPuntos
                }).then(function (response) {
                    //Cliente created successfully
                    $state.go('pedidosList', {pedidoId: response.data.id}, {reload: true});
                    var index = $scope.pedidosRecords.indexOf(response.data);
                    $scope.pedidosRecords.splice(index, 1);
                });
            };
        }
    ]);
}
)(window.angular);



