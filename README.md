# IP Receiver

IP Receiver is a Kotlin-based project dockerized for easy deployment. It retrieves and displays the IP address of the device it runs on directly in the command line.

## Getting Started

To use IP Receiver, follow these steps:

### Prerequisites

- Docker installed on your machine.

### Usage

1. **Build the Docker Image:**
   ```bash
   docker build -t ip-receiver .
   ```

2. **Run the Docker Container:**
   ```bash
   docker run --rm ip-receiver
   ```

3. **View IP Address:**
   The IP address of the device will be displayed in the command line after running the container.

