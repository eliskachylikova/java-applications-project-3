package cz.mendelu.ja.project3

import cz.mendelu.ja.project3.domain.danceStyle.DanceStyle
import cz.mendelu.ja.project3.domain.danceStyle.DanceStyleRepository
import cz.mendelu.ja.project3.domain.danceStyle.DanceStyleService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

class DanceStyleServiceUnitTest {
    private val danceStyleRepository: DanceStyleRepository = mockk()
    private val danceStyleService = DanceStyleService(danceStyleRepository)

    private val danceStyle = DanceStyle(1, "Dancehall", "Jamaica")
    private val danceStyle2 = DanceStyle(2, "Afro House", "Africa")

    @Test
    fun getById_test() {
        // given
        every { danceStyleRepository.findById(1) } returns Optional.of(danceStyle)

        // when
        val result = danceStyleService.getById(1)

        // then
        verify(exactly = 1) { danceStyleRepository.findById(1) }
        assertEquals(danceStyle, result)
    }

    @Test
    fun getAll_test() {
        // given
        every { danceStyleRepository.findAll() } returns listOf(danceStyle, danceStyle2)

        // when
        val result = danceStyleService.getAll()

        // then
        verify(exactly = 1) { danceStyleRepository.findAll() }
        assertEquals(listOf(danceStyle, danceStyle2), result)
    }
}