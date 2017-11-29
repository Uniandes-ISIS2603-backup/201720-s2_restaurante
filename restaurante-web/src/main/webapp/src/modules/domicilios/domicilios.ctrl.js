(function (ng) {
    var mod = ng.module("domicilioModule");//Definicion del modulo que usaremos desde el app.js
    mod.constant("domiciliosContext", "api/domicilios");
    mod.controller('domicilioCtrl', ['$scope', '$http', 'domiciliosContext','$state',
        /*
         * Informacion del domicilio obtenida desde el api de domicilios para representarla en los records del modulo
         */
        function ($scope, $http, domiciliosContext, $state) {
            $http.get(domiciliosContext).then(function (response) {
                $scope.domiciliosRecords = response.data;
            });
            $http.get("http://localhost:8080/restaurante-web/api/platos").then(function (response) {
                $scope.platosRecords = response.data;
            });
            $http.get("http://localhost:8080/restaurante-web/api/sucursales").then(function (response) {
                $scope.sucursalesRecords = response.data;
            });
            $http.get("http://localhost:8080/restaurante-web/api/clientes").then(function (response) {
                $scope.clientesRecords = response.data;
            });
            /*
            * Manejo del domicilio con un id especificado por parametro
            * Param: domicilioId
            */
            if (($state.params.domicilioId !== undefined) && ($state.params.domicilioId !== null)) {
                $http.get(domiciliosContext + '/' + $state.params.domicilioId).then(function (response) {
                    $scope.currentDomicilio = response.data;
                });
            }
            /*
            * Manejo del pedido con un id del domicilio especificado por parametro
            * Param: domicilioId
            */
            if (($state.params.domicilioId !== undefined) && ($state.params.domicilioId !== null)) {
                $http.get("http://localhost:8080/restaurante-web/api/pedidos" + '/' + $state.params.domicilioId).then(function (response) {
                    $scope.currentPedido = response.data;
                });
            }
            /*
            * Manejo del cliente con un id del domicilio especificado por parametro
            * Param: domicilioId
            */
            if (($state.params.clienteId !== undefined) && ($state.params.clienteId !== null)) {
                $http.get("http://localhost:8080/restaurante-web/api/clientes" + '/' + $state.params.clienteId).then(function (response) {
                    $scope.currentCliente = response.data;
                });
            }
        }
    ]);
}
)(angular);