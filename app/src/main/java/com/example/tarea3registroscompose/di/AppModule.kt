package com.example.tarea3registroscompose.di

import android.content.Context
import androidx.room.Room
import com.example.tarea3registroscompose.data.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun ProvidePrestamosDb(@ApplicationContext context: Context): PrestamosDb {
        return Room.databaseBuilder(
            context,
            PrestamosDb::class.java,
            "PrestamosDb")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun ProvidePersonaDAO(personasDB: PrestamosDb): PersonaDao {
        return personasDB.personaDao
    }

    @Provides
    fun ProvideOcupacionDAO(personasDB: PrestamosDb): OcupacionDao {
        return personasDB.ocupacionDao
    }

    @Provides
    fun providesOcupacionRepository(ocupacionDao: OcupacionDao): OcupacionRepository {
        return OcupacionRepository(ocupacionDao)
    }

    @Provides
    fun providesPersonaRepository(personaDao: PersonaDao): PersonaRepository {
        return PersonaRepository(personaDao)
    }
}