(
        function (ng) {
            var mod = ng.module("restauranteModule");
            mod.constant("authorsContext", "api/sucursales");
            mod.controller('authorUpdateCtrl', ['$scope', '$http', 'authorsContext', '$state', '$rootScope', '$filter',
                function ($scope, $http, authorsContext, $state, booksContext, $rootScope, $filter) {
                    $rootScope.edit = true;

                    var idRestaurante = $state.params.restauranteId;

                    $http.get(restaurantesContext + '/' + idRestaurante).then(function (response) {
                        var restaurante = response.data;
                        $scope.restauranteDireccion = restaurante.direccion;
                        $scope.restauranteDosPisos = restaurante.dosPisos;
                        $scope.restauranteCalificacion = restaurante.calificacion;
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
                        $http.put(authorsContext + "/" + idRestaurante, {
                        direccion: $scope.restauranteDireccion,
                        dosPisos: $scope.restauranteDosPisos,
                        calificacion: $scope.restauranteCalificacion
                        });
                    };
                }
            ]);
        }
)(angular);