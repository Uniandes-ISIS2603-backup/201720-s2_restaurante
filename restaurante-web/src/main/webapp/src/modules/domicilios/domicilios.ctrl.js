(function (ng) {
    var mod = ng.module("domiciliosModule");
    mod.constant("domiciliosContext", "api/domicilios");
    mod.controller('domiciliosCtrl', ['$scope', '$http', 'editorialContext',
        function ($scope, $http, domiciliosContext) {
            $http.get('data/domicilios.json').then(function (response) {
                $scope.domiciliosRecords = response.data;
            });
        }
    ]);
}
)(angular);