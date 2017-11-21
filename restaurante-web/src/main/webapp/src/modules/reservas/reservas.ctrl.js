(function (ng) {
    var mod = ng.module("reservaModule");
    mod.constant("reservasContext", "http://localhost:8080/restaurante-web/api/reservas");
    mod.controller('reservasCtrl', ['$scope', '$http', 'reservasContext','$state',
        function ($scope, $http, reservasContext, $state) {
            $http.get(reservasContext).then(function (response) { 
                $scope.reservasRecords = response.data;
            });
            
            if (($state.params.reservaId !== undefined) && ($state.params.reservaId !== null)) {
                $http.get(reservasContext + '/' + $state.params.reservaId).then(function (response) {
                    $scope.currentReserva = response.data;
                });
            }
        }
    ]);
}
)(window.angular);
 


