/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("clienteModule");
    mod.constant("clientesContext", "http://localhost:8080/restaurante-web/api/clientes");
    mod.controller('clienteNewCtrl', ['$scope', '$http', 'clientesContext', '$state', '$rootScope',
        function ($scope, $http, clientesContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.createCliente = function () {
                $http.post(clientesContext, {
                    nombre: $scope.clienteNombre,
                    apellido: $scope.clienteApellido,
//                    direccion: $scope.clienteDireccion,
                    numPuntos: $scope.clienteNumPuntos
                }).then(function (response) {
                    //Cliente created successfully
                    $state.go('clientesList', {clienteId: response.data.id}, {reload: true});
                    var index = $scope.clientesRecords.indexOf(response.data);
                    $scope.clientesRecords.splice(index, 1);
                });
            };
        }
    ]);
}
)(window.angular);

