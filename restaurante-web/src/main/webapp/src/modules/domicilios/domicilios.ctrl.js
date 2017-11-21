(function (ng) {
    var mod = ng.module("domicilioModule");
    mod.constant("domiciliosContext", "http://localhost:8080/restaurante-web/api/domicilios");
    mod.controller('domicilioCtrl', ['$scope', '$http', 'domiciliosContext',
        function ($scope, $http, domiciliosContext) {
            $http.get(domiciliosContext).then(function (response) {
                $scope.domiciliosRecords = response.data;
            });
        }
    ]);
}
)(angular);