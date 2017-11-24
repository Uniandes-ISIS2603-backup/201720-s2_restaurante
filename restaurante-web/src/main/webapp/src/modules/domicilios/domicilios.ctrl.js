(function (ng) {
    var mod = ng.module("domicilioModule");
    mod.constant("domiciliosContext", "api/domicilios");
    mod.controller('domicilioCtrl', ['$scope', '$http', 'domiciliosContext','$state',
        function ($scope, $http, domiciliosContext, $state) {
            $http.get(domiciliosContext).then(function (response) {
                $scope.domiciliosRecords = response.data;
            });
            if (($state.params.domicilioId !== undefined) && ($state.params.domicilioId !== null)) {
                $http.get(domiciliosContext + '/' + $state.params.domicilioId).then(function (response) {
                    $scope.currentDomicilio = response.data;
                });
            }
        }
    ]);
}
)(angular);