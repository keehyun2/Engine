#!/usr/bin/env python3
"""Run the RQ worker for ORE job execution."""
import redis
from rq import Worker, Queue, Connection

from app.config import settings

if __name__ == "__main__":
    conn = redis.from_url(settings.REDIS_URL)
    with Connection(conn):
        worker = Worker(Queue("ore_jobs"))
        print(f"Starting RQ worker, connected to {settings.REDIS_URL}")
        worker.work()
