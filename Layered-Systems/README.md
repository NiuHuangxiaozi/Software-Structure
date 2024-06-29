# Layered Systems



## 1. Introduction

Learn how to design a layered system.

------



## 2.Understanding

This demo code is divided into three layers: CLI, the business logic layer (biz), and the underlying database layer (db). The CLI is responsible only for handling user logic, input, and output. The PosService provides processed output data to the CLI and processes input data to be handed over to the database management layer. The db layer manages data storage and provides the necessary query functionality. This is the layered programming framework. When we need to integrate a real MySQL or Redis database in the future, we only need to modify the code in the db layer, keeping the interface unchanged for the upper layers, and the system will continue to function properly.











