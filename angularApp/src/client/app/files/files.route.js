(function() {
    'use strict';

    angular
        .module('app.files')
        .run(appRun);

    appRun.$inject = ['routerHelper'];
    /* @ngInject */
    function appRun(routerHelper) {
        routerHelper.configureStates(getStates());
    }

    function getStates() {
        return [
            {
                state: 'files',
                config: {
                    url: '/#',
                    templateUrl: 'app/files/files.html',
                    controller: 'FilesController',
                    controllerAs: 'vm',
                    title: 'Files',
                    settings: {
                        nav: 1,
                        content: '<i class="fa fa-lock"></i> Files'
                    }
                }
            }
        ];
    }
})();
