@echo off
setlocal enabledelayedexpansion

set CONTAINER_NAME=demo-container
set IMAGE_NAME=build

REM Set the default docker command
set DOCKER_CMD=docker

REM Check if the -c parameter is provided
if "%~1" == "-c" (
    set DOCKER_CMD=docker -c %~2
    shift
)

REM Build image
%DOCKER_CMD% build -f build.Dockerfile -t %IMAGE_NAME% .

REM Start the Docker container in the background
%DOCKER_CMD%  run -d --name %CONTAINER_NAME% %IMAGE_NAME%

REM Copy jars to result directory on the host
RMDIR /S /Q result
MKDIR result
%DOCKER_CMD% cp %CONTAINER_NAME%:/app/target/MicronautDemo-1.0-SNAPSHOT.jar ./result/Demo.jar

MKDIR result\test_reports
%DOCKER_CMD% cp %CONTAINER_NAME%:/app/target/surefire-reports/. ./result/test_reports/

REM Stop, remove and delete the container
%DOCKER_CMD% stop %CONTAINER_NAME%
%DOCKER_CMD% rm %CONTAINER_NAME%
REM docker rmi %IMAGE_NAME%
