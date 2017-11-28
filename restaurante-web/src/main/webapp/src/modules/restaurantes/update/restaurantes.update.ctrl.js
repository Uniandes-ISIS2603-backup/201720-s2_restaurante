(
        function (ng) {
            var mod = ng.module("restauranteModule");//Definicion del modulo que usaremos desde el app.js
            mod.constant("restaurantesContext", "http://localhost:8080/restaurante-web/api/sucursales");
            mod.controller('restauranteUpdateCtrl', ['$scope', '$http', 'restaurantesContext', '$state', '$rootScope', '$filter',
                function ($scope, $http, restaurantesContext, $state, $rootScope) {
                    $rootScope.edit = true;

                    var idRestaurante = $state.params.restauranteId;//id que usaremos para especificar un restaurante, viene de un parametro
                    //Consulto el restaurante a editar
                    $http.get(restaurantesContext + '/' + idRestaurante).then(function (response) {
                        var restaurante = response.data;
                        $scope.restauranteDireccion = restaurante.direccion;
                        $scope.restauranteDosPisos = restaurante.dosPisos;
                        $scope.restauranteCalificacion = restaurante.calificacion;
                        $scope.restauranteImage1 = restaurante.image;
                    });
                    //funciones para el drag and drop de HTML5 nativo
                    $scope.allowDrop = function (ev) {
                        ev.preventDefault();
                    };
                    $scope.drag = function (ev) {
                        ev.dataTransfer.setData("text", ev.target.id);
                    };
                    $scope.dropAdd = function (ev) {
                        ev.preventDefault();
                        var data = ev.dataTransfer.getData("text");
                        ev.target.appendChild(document.getElementById(data));
                    };
                    $scope.createRestaurante = function () {
                        $http.put(restaurantesContext + "/" + idRestaurante, {
                        direccion: $scope.restauranteDireccion,
                        dosPisos: $scope.restauranteDosPisos,
                        calificacion: $scope.restauranteCalificacion,
                        image: $scope.restauranteImage1
                        }).then(function (response) {
                    //restaurante created successfully
                    $state.go('restaurantesList', {restauranteId: response.data.id}, {reload: true});
                });
                    };
                }
            ]);
        }
)(angular);