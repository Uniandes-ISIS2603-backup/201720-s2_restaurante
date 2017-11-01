/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("pedidoModule");
    mod.constant("pedidosContext", "api/pedidos");
    mod.controller('pedidosCtrl', ['$scope', '$http', 'pedidosContext',
        function ($scope, $http, pedidosContext) {
            $http.get('data/pedidos.json').then(function (response) {
                $scope.pedidosRecords = response.data;
            });
       if ($state.params.pedidoId !== undefined) {
                $http.get(pedidosContext + '/' + $state.params.pedidoId).then(function (response) {
                    $scope.currentCliente = response.data;
                });
            }
        }
    ]);
}
)(window.angular);

