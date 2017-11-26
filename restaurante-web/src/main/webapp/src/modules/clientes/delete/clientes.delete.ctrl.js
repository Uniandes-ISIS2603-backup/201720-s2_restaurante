/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("clienteModule");//Definicion del modulo que usaremos desde el app.js
    mod.constant("clientesContext", "api/clientes");
    mod.controller('clienteDeleteCtrl', ['$scope', '$http', 'clientesContext', '$state',
        /*
         * Eliminamos un cliente con id especificado por parametro
         * Param: clienteId
         */
        function ($scope, $http, clientesContext, $state) {
            var idCliente = $state.params.clienteId;
            $scope.deleteCliente = function () {
                $http.delete(clientesContext + '/' + idCliente, {}).then(function (response) {
                    $state.go('clientesList', {clienteId: response.data.id}, {reload: true});
                    var index = $scope.clientesRecords.indexOf(response.data); //actualizamos los records de la vista
                    $scope.clientesRecords.splice(index, 1);
                });
            };
        }
    ]);
}
)(window.angular);

