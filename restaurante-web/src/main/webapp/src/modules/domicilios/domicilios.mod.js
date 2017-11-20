(function (ng){
   var mod=ng.module("domicilioModule",['ui.router']);
   
   mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/domicilios/';
            $urlRouterProvider.otherwise("/domiciliosList");
            $stateProvider.state('domicilios', {
                url: '/domicilios',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'domicilios.html',
                        controller: 'domicilioCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('domiciliosList', {
                url: '/domicilios/list',
                parent: 'domicilios',
                views: {
                   'listView': {
                        templateUrl: basePath + 'domicilios.list.html'
                    }
                }
            }).state('domicilioDetail', {
                url: '/{domicilioId:int}/detail',
                parent: 'domicilios',
                param: {
                    restauranteId: null
                },
                views: {
                    'listView': {
                        controller: 'domicilioCtrl',
                        controllerAs: 'ctrl'
                    },
                    'detailView': {
                        templateUrl: basePath + 'domicilios.detail.html',
                        controller: 'domicilioCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('domiciliosCreate', {
                url: '/create',
                parent: 'domicilios',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/domicilios.new.html',
                        controller: 'domicilioNewCtrl'
                    }
                }
            }).state('domicilioDelete', {
                url: '/delete/{domicilioId:int}',
                parent: 'domicilios',
                param: {
                    domicilioId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/domicilio.delete.html',
                        controller: 'domicilioDeleteCtrl'
                    }
                }
            });
        }
    ]);
})(window.angular);