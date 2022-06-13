FROM edoburu/pgbouncer:1.15.0
COPY --chown=postgres:root pgbouncer.ini /etc/pgbouncer/
RUN chmod 644 /etc/pgbouncer/pgbouncer.ini
COPY --chown=postgres:root userlist.txt /etc/pgbouncer/
RUN chmod 644 /etc/pgbouncer/userlist.txt
