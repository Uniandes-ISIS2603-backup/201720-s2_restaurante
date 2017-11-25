(
        function (ng) {
            var mod = ng.module("reservaModule");
            mod.constant("reservasContext", "http://localhost:8080/restaurante-web/api/reservas");
            mod.controller('reservaUpdateCtrl', ['$scope', '$http', 'reservasContext', '$state', '$rootScope', '$filter',
                function ($scope, $http, reservasContext, $state, $rootScope) {
                    $rootScope.edit = true;

                    var idreserva = $state.params.reservaId;

                    
                    $http.get(reservasContext + '/' + idreserva).then(function (response) {
                        var reserva = response.data;
                        $scope.reservaFecha = new Date(reserva.fecha);
                        $scope.reservaMesa = reserva.mesaId;
                        
                    });

                    
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
                    
                    $scope.createReserva = function () {
                        
                        $http.put(reservasContext + "/" + idreserva, {
                            
                            fecha: $scope.reservaFecha,
                            mesaId: $scope.reservaMesa
                            
                        }).then(function (response) {
                    //Reserva created successfully
                    $state.go('reservasList', {reservaId: response.data.id}, {reload: true});
                });
                    };

                }
            ]);
        }
)(window.angular);