(function () {
    angular.module('boulimiqueLitteraire').
        controller('HomeCtrl', ['$scope', '$location', 'ArticleFactory',
        function ($scope, $location, ArticleFactory) {

        $scope.lastArticles = [];
        $scope.interval = 7000;
        function init() {
            ArticleFactory.getLastArticles().
                then(function(data){
                    $scope.lastArticles = data;
                }, function(error){
                    console.log(error.data.message);
                });
        }

        init();
    }]);
}());