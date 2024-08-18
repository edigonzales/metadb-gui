## Dev database

```
docker run --rm --name simidb -p 54324:5432 -v pgdata-simi:/var/lib/postgresql/data:delegated -e POSTGRES_PASSWORD=secret -e POSTGRES_DB=simi sogis/postgis:16-3.4
```

## Prepare

1. In _dbeaver_ die "globals"-Datei ausführen. Postgres-Benutzer ist auskommentiert, da es ihn schon gibt.
2. Dump in den Docker Container kopieren:

```
docker cp ./simi.sql simidb:/tmp/simi.sql
```

3. Dump restoren:

```
docker exec -it simidb bash
```

```
psql -U postgres -W --single-transaction -d simi -f /tmp/simi.sql
```

Die _simi.sql_-Datei wurd aus dem Original-Dump abgeleitet. Zuerst wurde eine Ascii-Datei aus dem Binary-Dump gemacht, um anschliessend Python-Funktions-Gedöns auszukommentieren (von pgwatch?).