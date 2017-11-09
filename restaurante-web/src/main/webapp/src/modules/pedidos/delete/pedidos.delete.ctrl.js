/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module("pedidoModule");
    mod.constant("pedidosContext", "api/pedidos");
    mod.controller('pedidoDeleteCtrl', ['$scope', '$http', 'pedidosContext', '$state',
        function ($scope, $http, pedidosContext, $state) {
            var idPedido = $state.params.pedidoId;
            $scope.deletePedido = function () {
                $http.delete(pedidosContext + '/' + idPedido, {}).then(function (response) {
                    
                    var index = $scope.pedidosRecords.indexOf(response.data);
                    $scope.pedidosRecords.splice(index, 1);
                    $state.go('pedidosList', {pedidoId: response.data.id}, {reload: true});
                    
                });
            };
        }
    ]);
}
)(window.angular);
