/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//(function (ng) {
//    var mod = ng.module("clienteModule");
//    mod.constant("clientesContext", "api/clientes");
//    mod.controller('clienteDeleteCtrl', ['$scope', '$http', 'clientesContext', '$state',
//        function ($scope, $http, clientesContext, $state) {
//            var idCliente = $state.params.clienteId;
//            $scope.deleteCliente = function () {
//                $http.delete(clientesContext + '/' + idCliente, {}).then(function (response) {
//                    $state.go('clientesList', {clienteId: response.data.id}, {reload: true});
//                });
//            };
//        }
//    ]);
//}
//)(window.angular);
(function (ng) {
    var mod = ng.module("clienteModule");
    mod.constant("clientesContext", "api/clientes");
    mod.controller('clienteDeleteCtrl', ['$scope', '$http', 'clientesContext', '$state',
        function ($scope, $http, clientesContext, $state) {
            var idCliente = $state.params.clienteId;
            $scope.deleteCliente = function () {
                $http.delete(clientesContext + '/' + idCliente, {}).then(function (response) {
                    $state.go('clientesList', {clienteId: response.data.id}, {reload: true});
                    var index = $scope.clientesRecords.indexOf(response.data);
                    $scope.clientesRecords.splice(index, 1);
                });
            };
        }
    ]);
}
)(window.angular);

