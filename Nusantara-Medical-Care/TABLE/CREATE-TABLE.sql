-- Database: nmcdb

-- DROP DATABASE IF EXISTS nmcdb;

CREATE DATABASE nmcdb
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Indonesian_Indonesia.1252'
    LC_CTYPE = 'Indonesian_Indonesia.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE TABLE IF NOT EXISTS public.administrator
(
    idadministrator integer NOT NULL,
    idklinik integer,
    CONSTRAINT idadministrator PRIMARY KEY (idadministrator),
    CONSTRAINT administrator_idadministrator_fkey FOREIGN KEY (idadministrator)
        REFERENCES public.pegawai (idpegawai) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT idklinik FOREIGN KEY (idklinik)
        REFERENCES public.poliklinik (idklinik) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)

CREATE TABLE IF NOT EXISTS public.adminsistem
(
    idadminsistem integer NOT NULL,
    CONSTRAINT adminsistem_pkey PRIMARY KEY (idadminsistem),
    CONSTRAINT adminsistem_idadminsistem_fkey FOREIGN KEY (idadminsistem)
        REFERENCES public.pegawai (idpegawai) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.adminsistem
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.diagnosa
(
    iddiagnosa integer NOT NULL DEFAULT nextval('diagnosa_iddiagnosa_seq'::regclass),
    namadiagnosa character varying(50) COLLATE pg_catalog."default" NOT NULL,
    iddokter integer,
    CONSTRAINT diagnosa_pkey PRIMARY KEY (iddiagnosa),
    CONSTRAINT iddokter FOREIGN KEY (iddokter)
        REFERENCES public.dokter (iddokter) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.diagnosa
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.diagnosapasien
(
    iddiagnosa integer NOT NULL,
    norekammedispasien character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT diagnosapasien_iddiagnosa_fkey FOREIGN KEY (iddiagnosa)
        REFERENCES public.diagnosa (iddiagnosa) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT diagnosapasien_norekammedispasien_fkey FOREIGN KEY (norekammedispasien)
        REFERENCES public.pasien (norekammedispasien) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.diagnosapasien
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.dokter
(
    iddokter integer NOT NULL,
    spesialisdokter character varying(20) COLLATE pg_catalog."default" NOT NULL,
    idklinik integer,
    CONSTRAINT iddokter PRIMARY KEY (iddokter),
    CONSTRAINT dokter_iddokter_fkey FOREIGN KEY (iddokter)
        REFERENCES public.pegawai (idpegawai) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT idklinik FOREIGN KEY (idklinik)
        REFERENCES public.poliklinik (idklinik) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.dokter
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.informasidasarpasien
(
    idinformasi integer NOT NULL DEFAULT nextval('informasidasarpasien_idinformasi_seq'::regclass),
    norekammedispasien character varying(50) COLLATE pg_catalog."default" NOT NULL,
    tanggalperiksa date NOT NULL,
    tinggibadan character varying(10) COLLATE pg_catalog."default" NOT NULL,
    tekanandarah character varying(10) COLLATE pg_catalog."default" NOT NULL,
    beratbadan character varying(10) COLLATE pg_catalog."default" NOT NULL,
    suhutubuh character varying(10) COLLATE pg_catalog."default" NOT NULL,
    keluhan text COLLATE pg_catalog."default" NOT NULL,
    resepobat character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT informasidasarpasien_pkey PRIMARY KEY (idinformasi)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.informasidasarpasien
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.pasien
(
    norekammedispasien character varying(50) COLLATE pg_catalog."default" NOT NULL,
    namapasien character varying(50) COLLATE pg_catalog."default" NOT NULL,
    nohppasien character varying(20) COLLATE pg_catalog."default",
    tgllahirpasien date NOT NULL,
    jeniskelaminpasien character varying(1) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT norekammedispasien PRIMARY KEY (norekammedispasien),
    CONSTRAINT pasien_nohppasien_key UNIQUE (nohppasien),
    CONSTRAINT pasien_norekammedispasien_key UNIQUE (norekammedispasien)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.pasien
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.pegawai
(
    idpegawai integer NOT NULL DEFAULT nextval('pegawai_idpegawai_seq'::regclass),
    usernamepegawai character varying(20) COLLATE pg_catalog."default" NOT NULL,
    passwordpegawai character varying(20) COLLATE pg_catalog."default" NOT NULL,
    namapegawai character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT pegawai_pkey PRIMARY KEY (idpegawai)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.pegawai
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.pendaftaran
(
    idpendaftaran integer NOT NULL DEFAULT nextval('pendaftaran_idpendaftaran_seq'::regclass),
    tglpendaftaran date NOT NULL,
    jammulai time without time zone NOT NULL,
    jamakhir time without time zone NOT NULL,
    idklinik integer,
    idadministrator integer,
    CONSTRAINT pendaftaran_pkey PRIMARY KEY (idpendaftaran),
    CONSTRAINT idadministrator FOREIGN KEY (idadministrator)
        REFERENCES public.administrator (idadministrator) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT idklinik FOREIGN KEY (idklinik)
        REFERENCES public.poliklinik (idklinik) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.pendaftaran
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.pendaftaranpasien
(
    idpendaftaran integer NOT NULL,
    norekammedispasien character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pendaftaranpasien_idpendaftaran_fkey FOREIGN KEY (idpendaftaran)
        REFERENCES public.pendaftaran (idpendaftaran) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT pendaftaranpasien_norekammedispasien_fkey FOREIGN KEY (norekammedispasien)
        REFERENCES public.pasien (norekammedispasien) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.pendaftaranpasien
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.perawat
(
    idperawat integer NOT NULL,
    idklinik integer,
    CONSTRAINT idklinik FOREIGN KEY (idklinik)
        REFERENCES public.poliklinik (idklinik) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT perawat_idperawat_fkey FOREIGN KEY (idperawat)
        REFERENCES public.pegawai (idpegawai) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.perawat
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.poliklinik
(
    idklinik integer NOT NULL DEFAULT nextval('poliklinik_idklinik_seq'::regclass),
    namaklinik character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT poliklinik_pkey PRIMARY KEY (idklinik)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.poliklinik
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.transaksi
(
    idtransaksi integer NOT NULL DEFAULT nextval('transaksi_idtransaksi_seq'::regclass),
    tanggaltransaksi date NOT NULL,
    jenistransaksi character varying(10) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT transaksi_pkey PRIMARY KEY (idtransaksi)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.transaksi
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.transaksipasien
(
    idtransaksi integer NOT NULL,
    norekammedispasien character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT transaksipasien_idtransaksi_fkey FOREIGN KEY (idtransaksi)
        REFERENCES public.transaksi (idtransaksi) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT trasaksipasien_norekammedispasien_fkey FOREIGN KEY (norekammedispasien)
        REFERENCES public.pasien (norekammedispasien) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.transaksipasien
    OWNER to postgres;