'use strict';

angular.module('app')
    .controller("TroubleshootCtrl", ['$scope', '$http', 'Constants', '$timeout',
        function ($scope, $http, Constants, $timeout) {

            $scope.consts = Constants;
            $scope.taskInProgress = false;

            fetchItems();

            function fetchItems() {
                $http.get("service/troubleshoot/list").success(function (data) {
                    console.log("Troubleshoot tasks.");
                    console.log(data);
                    $scope.items = data;
                });
            }

            $scope.claimTask = function (taskId) {
                $http.post("service/broker/claimTask", taskId).then(
                    function successCallback(data) {
                        $scope.successMessage = "Task claimed Successfully";
                        $scope.successVisible = true;
                        fetchTasks();
                        $timeout(function () {
                            $scope.successVisible = false;
                            $scope.successMessage = "";
                        }, 2000);
                    },
                    function errorCallback(data) {
                        $scope.errorMessage = "Error occurred while attempting to claim task";
                        $scope.errorVisible = true;
                        fetchTasks();
                        console.log("ERROR: " + JSON.stringify({data: data}));
                        $timeout(function () {
                            $scope.errorVisible = false;
                            $scope.errorMessage = "";
                        }, 2000);
                    });
            };

      }]);
