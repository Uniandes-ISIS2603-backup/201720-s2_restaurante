(function (ng) {
    var mod = ng.module("domicilioModule");
    mod.constant("domiciliosContext", "api/domicilios");
    mod.controller('domiciliosCtrl', ['$scope', '$http', 'domiciliosContext',
        function ($scope, $http, domiciliosContext) {
            $http.get('data/domicilios.json').then(function (response) {
                $scope.domiciliosRecords = response.data;
            });
        }
    ]);
}
)(angular);