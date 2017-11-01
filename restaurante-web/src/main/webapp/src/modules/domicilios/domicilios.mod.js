(function (ng){
   var mod=ng.module("domicilioModule",['ui.router']);
   
   mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/domicilios/';
            $urlRouterProvider.otherwise("/domiciliosList");
            $stateProvider.state('domiciliosList', {
                url: '/domicilios/list',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'domicilios.list.html',
                        controller: 'domiciliosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    ]);
})(window.angular);