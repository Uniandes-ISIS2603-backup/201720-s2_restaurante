(
        function (ng) {
            var mod = ng.module("domicilioModule");//Definicion del modulo que usaremos desde el app.js
            mod.constant("domiciliosContext", "http://localhost:8080/restaurante-web/api/domicilios");
            mod.controller('domicilioUpdateCtrl', ['$scope', '$http', 'domiciliosContext', '$state', '$rootScope', '$filter',
                function ($scope, $http, domiciliosContext, $state, $rootScope) {
                    $rootScope.edit = true;
                    var idDomicilio = $state.params.domicilioId;//id que usaremos para especificar un domicilio, viene de un parametro                  
                    //Consulto el domicilio a editar.
                    $http.get(domiciliosContext + '/' + idDomicilio).then(function (response) {
                        var domicilio = response.data;
                        $scope.platos = domicilio.platos;
                        $scope.rango = domicilio.rango;             
                    });
                    $http.get("http://localhost:8080/restaurante-web/api/pedidos" + '/' + $state.params.domicilioId).then(function (response) {
                        var pedido = response.data;
                        $scope.nombre = pedido.name;
                        $scope.direccion = pedido.direccion;
                    });
                    $scope.createDomicilio = function () {
                        $http.put("http://localhost:8080/restaurante-web/api/pedidos", {
                            direccion: $scope.direccion,
                            id: idDomicilio,
                            name: $scope.nombre
                        });
                        $http.put(domiciliosContext + "/" + idDomicilio, {
                            id: idDomicilio,
                            platos: $scope.platos,
                            rango: $scope.rango
                        }).then(function (response) {
                        //domicilio creado de forma exitosa    
                        $state.go('domiciliosList', {domicilioId: response.data.id}, {reload: true});
                });
                    };
                }
            ]);
        }
)(window.angular);