package di

import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    single(named("title")) { "Onboarding " }
    single(named("subtitle")) { "Welcome to the app" }
}

