package com.dascamp.myapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dascamp.myapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var bindingFragmentHomeBinding: FragmentHomeBinding
    private val binding1 get() = bindingFragmentHomeBinding

    private lateinit var filmsAdapter: FilmListRecyclerAdapter

    private val filmsDataBase = listOf(
        Film(
            "Angry Birds",
            R.drawable.angry_birds,
            "When an island populated by happy, flightless birds is visited by mysterious green piggies, it's up to three unlikely outcasts - Red, Chuck and Bomb - to figure out what the pigs are up to."
        ),
        Film(
            "Hotel Transylvania 3: Summer Vacation",
            R.drawable.hotel,
            "Mavis surprises Dracula with a family voyage on a luxury Monster Cruise Ship so he can take a vacation from providing everyone else's vacation at the hotel. "
        ),
        Film(
            "Frozen",
            R.drawable.frozen,
            "When the newly crowned Queen Elsa accidentally uses her power to turn things into ice to curse her home in infinite winter, her sister Anna teams up with a mountain man, his playful reindeer, and a snowman to change the weather condition."
        ),
        Film(
            "Inspector Sun and the Curse of the Black Widow",
            R.drawable.inspector,
            "Set in the world of bugs where spiders are the cops, a detective boards a seaplane to San Francisco after finally capturing his arch nemesis, but a murder on his flight draws him into a plot that threatens both the human and bug worlds."
        ),
        Film(
            "The Nutcracker and the Four Realms",
            R.drawable.nutcracker,
            "A young girl is transported into a magical world of gingerbread soldiers and an army of mice."
        ),
        Film(
            "Rapunzel",
            R.drawable.rapunzel,
            "The story depicts Rapunzel as the adoptive daughter of the Witch that the Baker (Rapunzel's older brother, unbeknownst to him."
        ),
        Film(
            "Aquaman",
            R.drawable.aquaman,
            "Arthur Curry, the human-born heir to the underwater kingdom of Atlantis, goes on a quest to prevent a war between the worlds of ocean and land."
        ),
        Film(
            "Minions",
            R.drawable.minions,
            "Minions Stuart, Kevin, and Bob are recruited by Scarlet Overkill, a supervillain who, alongside her inventor husband Herb, hatches a plot to take over the world."
        ),
        Film(
            "Rio",
            R.drawable.rio,
            "When Blu, a domesticated macaw from small-town Minnesota, meets the fiercely independent Jewel, he takes off on an adventure to Rio de Janeiro with the bird of his dreams."
        ),
        Film(
            "Ant-man",
            R.drawable.ant_man,
            "Armed with a super-suit with the astonishing ability to shrink in scale but increase in strength, cat burglar Scott Lang must embrace his inner hero and help his mentor, Dr. Hank Pym, pull off a plan that will save the world."
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingFragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding1.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingFragmentHomeBinding.mainRecycler.apply {
            filmsAdapter =
                FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                    override fun click(film: Film) {
                        (requireActivity() as MainActivity).launchDetailsFragment(film)
                    }
                })
            adapter = filmsAdapter
            layoutManager = LinearLayoutManager(requireContext())
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
        filmsAdapter.addItems(filmsDataBase)
    }
}