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
}