FROM eclipse-temurin:17-jdk

# Install maven and git (non-interactive)
RUN apt-get update \
  && DEBIAN_FRONTEND=noninteractive apt-get install -y --no-install-recommends \
     maven \
     git \
  && rm -rf /var/lib/apt/lists/*

WORKDIR /workspace
