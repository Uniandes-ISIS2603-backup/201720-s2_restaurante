(function (ng) {
    var mod = ng.module("domicilioModule");//Definicion del modulo que usaremos desde el app.js
    mod.constant("domiciliosContext", "http://localhost:8080/restaurante-web/api/domicilios");
    mod.controller('domicilioNewCtrl', ['$scope', '$http', 'domiciliosContext', '$state', '$rootScope',
        function ($scope, $http, domiciliosContext, $state, $rootScope) {
            $rootScope.edit = false;
            /*
             * Funcion para crear un nuevo domicilio a partir de los parametros definidos en el back
             */
            $scope.createDomicilio = function () {
                $http.post("http://localhost:8080/restaurante-web/api/pedidos", {
                    direccion: $scope.direccion,
                    id: -1,
                    dirSucursal:$scope.dirSuc
                });
                $http.post("http://localhost:8080/restaurante-web/api/clientes", {
                    nombre: $scope.nombre
                });
                $http.post(domiciliosContext, {
                    id: -1,
                    plato1: $scope.plato1,
                    plato2:$scope.plato2,
                    plato3:$scope.plato3,
                    plato4:$scope.plato4,
                    plato5:$scope.plato5,
                    rango: 10
                }).then(function (response) {
                //domicilio created successfully    
                $state.go('domiciliosList', {domicilioId: response.data.id}, {reload: true});
                    var index = $scope.domiciliosRecords.indexOf(response.data);
                    $scope.domiciliosRecords.splice(index, 1);
                });
            };
        }
    ]);
}
)(window.angular);