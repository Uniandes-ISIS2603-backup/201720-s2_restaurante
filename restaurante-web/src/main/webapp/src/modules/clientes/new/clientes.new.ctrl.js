/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("clienteModule");//Definicion del modulo que usaremos desde el app.js
    mod.constant("clientesContext", "http://localhost:8080/restaurante-web/api/clientes");
    mod.controller('clienteNewCtrl', ['$scope', '$http', 'clientesContext', '$state', '$rootScope',
        function ($scope, $http, clientesContext, $state, $rootScope) {
            $rootScope.edit = false;
            /*
             * Funcion para crear un nuevo cliente a partir de los parametros definidos en el back
             */
            $scope.createCliente = function () {
                $http.post(clientesContext, {
                    nombre: $scope.clienteNombre,
                    apellido: $scope.clienteApellido,
//                    direccion: $scope.clienteDireccion,
                    numPuntos: $scope.clienteNumPuntos
                }).then(function (response) {
                    //Cliente created successfully
                    $state.go('clientesList', {clienteId: response.data.id}, {reload: true});
                    var index = $scope.clientesRecords.indexOf(response.data); //actualizar los records con la informacion provista por el clietne
                    $scope.clientesRecords.splice(index, 1);
                });
            };
        }
    ]);
}
)(window.angular);

