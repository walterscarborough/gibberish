# Gibberish Dictionary

This is a simple command line based foreign language dictionary written in Java.

I created it to help test out software architecture measurement detections as part of my master's report for graduate school. Gibberish was designed from a formal software architecture that favors code reusability over performance.

It is very useful as a simple piece of software to analyze, and although it does work as a dictionary, it is better suited as test software for metrics, measurements, and architecture analysis.

## Architecture Highlights

Here are some of the architectural highlights in case you want you to reuse this project for your own experiments and analyses:

**Coupling and Cohesion Metrics**

* Number of Inputs/Outputs Between Components
  * User I/O Handler
    * Inputs: 1
    * Outputs: 7
  * Language Handler
    * Inputs: 1
    * Outputs: 1
  * Language Bank
    * Inputs: 5
    * Outputs: 3
  
* Number of Dependencies Between Components
  * User I/O Handler: 1
  * Language Handler: 2
  * Language Bank: 2

* Degree of Cohesion
  * User I/O Handler: 2/3
  * Language Handler: 2/3
  * Language Bank: 0

**Size and Complexity Metrics**

* Number of Functions in a Component
  * User I/O Handler: 3
  * Language Handler: 3
  * Language Bank: 2

* Number of Data Elements in a Component
  * User I/O Handler: 0
  * Language Handler: 2
  * Language Bank: 1
  * Total Components: 3 

## Contributions

Contributions are welcome! Feel free to submit a pull request.

This software is licensed under the GPL v2. For more information, please see the LICENSE file included in this repository.
