/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("clienteModule"); //Definicion del modulo que usaremos desde el app.js
    mod.constant("clientesContext", "api/clientes");
    mod.controller('clientesCtrl', ['$scope', '$http', 'clientesContext','$state',
        /*
         * Informacion del cliente obtenida desde el api de clientes para representarla en los records del modulo
         */
        function ($scope, $http, clientesContext, $state) {
            $http.get('http://localhost:8080/restaurante-web/api/clientes').then(function (response) {
                $scope.clientesRecords = response.data;
            });
        
        /*
         * Manejo del cliente con un id especificado por parametro
         * Param: clienteId
         */
        if (($state.params.clienteId !== undefined) 
                ) {
                $http.get(clientesContext + '/' + $state.params.clienteId).then(function (response) {
                    $scope.currentCliente = response.data;
                });
            }
        }
    ]);
}
)(window.angular);


