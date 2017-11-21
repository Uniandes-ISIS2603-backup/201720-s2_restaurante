/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//(function (ng) {
//    var mod = ng.module("clienteModule");
//    mod.constant("clientesContext", "api/clientes");
//    mod.controller('clientesCtrl', ['$scope', '$http', 'clientesContext',
//        function ($scope, $http, clientesContext) {
//            $http.get('data/clientes.json').then(function (response) { //ese json se crea en data, son las colecciones
//                                                                       //el get es un sistema de promesas
//                $scope.clientesRecords = response.data;
//            });
//        }
//    ]);
//}
//)(angular);
(function (ng) {
    var mod = ng.module("clienteModule");
    mod.constant("clientesContext", "api/clientes");
    mod.controller('clientesCtrl', ['$scope', '$http', 'clientesContext','$state',
        function ($scope, $http, clientesContext, $state) {
            $http.get('http://localhost:8080/restaurante-web/api/clientes').then(function (response) {
                $scope.clientesRecords = response.data;
            });
//       if (($state.params.clienteId !== undefined) && ($state.params.clienteId !== null)) {
//                $http.get(clientesContext + '/' + $state.params.clienteId).then(function (response) {
//                    $scope.currentCliente = response.data;
//                });
//            }
        if (($state.params.clientesId !== undefined) && ($state.params.clientesId !== null)) {
                $http.get(clientesContext + '/' + $state.params.clientesId).then(function (response) {
                    $scope.currentCliente = response.data;
                });
            }
        }
    ]);
}
)(window.angular);


