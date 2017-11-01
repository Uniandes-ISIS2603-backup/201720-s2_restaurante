(function (ng){
   var mod=ng.module("domiciliosModule",['ui.router']);
   
   mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/domicilios/';
            $urlRouterProvider.otherwise("/domiciliosList");
            $stateProvider.state('domiciliosList', {
                url: '/domicilios/list',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'domicilios.list.html',
                        controller: 'domicilioCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    ]);
})(window.angular);