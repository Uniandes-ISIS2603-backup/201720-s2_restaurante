(function (ng) {
    var mod = ng.module("reservaModule");
    mod.constant("reservasContext", "api/reservas");
    mod.controller('reservasCtrl', ['$scope', '$http', 'reservasContext',
        function ($scope, $http, reservaContext) {
            $http.get('data/reservas.json').then(function (response) { 
                $scope.reservasRecords = response.data;
            });
            
            if ($state.params.reservaId !== undefined) {
                $http.get(reservasContext + '/' + $state.params.reservaId).then(function (response) {
                    $scope.currentreserva = response.data;
                });
            }
        }
    ]);
}
)(window.angular);
 


