package com.shipsco.charactersheet

import android.app.Application
import android.view.View
import androidx.lifecycle.*
import com.shipsco.charactersheet.data.character.Character
import com.shipsco.charactersheet.domain.CharacterUseCase
import com.shipsco.charactersheet.views.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.math.ceil

class CharacterViewModel(
    application: Application,
    private val characterUseCase: CharacterUseCase
): AndroidViewModel(application), ManualEditListener {
    private val _allCharacters = MutableLiveData<List<Character>>()
    val allCharacters: LiveData<List<Character>> = _allCharacters

    private val _currentCharacter = MutableLiveData<Character>()
    val currentCharacter: LiveData<Character> = _currentCharacter

    private val _proficiencyBonus = MutableLiveData<String>()
    val proficiencyBonus:LiveData<String> = _proficiencyBonus

    private val _currentHitPoint = MutableLiveData<String>()
    val currentHitPoints:LiveData<String> = _currentHitPoint

    private val _strengthBonus = MutableLiveData<String>()
    val strengthBonus:LiveData<String> = _strengthBonus

    private val _dexterityBonus = MutableLiveData<String>()
    val dexterityBonus:LiveData<String> = _dexterityBonus

    private val _constitutionBonus = MutableLiveData<String>()
    val constitutionBonus:LiveData<String> = _constitutionBonus

    private val _intelligenceBonus = MutableLiveData<String>()
    val intelligenceBonus:LiveData<String> = _intelligenceBonus

    private val _wisdomBonus = MutableLiveData<String>()
    val wisdomBonus:LiveData<String> = _wisdomBonus

    private val _charismaBonus = MutableLiveData<String>()
    val charismaBonus:LiveData<String> = _charismaBonus

    fun getCharacters() {
        runBlocking {
            _allCharacters.postValue(characterUseCase.getCharacters())
        }
    }

    fun setCharacter(character: Character) {
        _currentCharacter.postValue(character)
    }

    fun getCharacter(characterName: String): Character {
        var character = Character()
        runBlocking {
            characterUseCase.getCharacter(characterName)
                .onSuccess {
                    character = it
                }
                .onFailure {  }
            _currentCharacter.postValue(character)
        }
        return character
    }

    fun saveCharacter(newCharacter: Character) {
        if (newCharacter.characterName.isNotBlank()) {
            viewModelScope.launch {
                characterUseCase.getCharacter(newCharacter.characterName)
                    .onSuccess {
                        characterUseCase.updateCharacter(newCharacter)
                        _currentCharacter.postValue(newCharacter)
                        _allCharacters.postValue(characterUseCase.getCharacters())
                    }
                    .onFailure {
                        characterUseCase.addCharacter(newCharacter)
                        _currentCharacter.postValue(newCharacter)
                        _allCharacters.postValue(characterUseCase.getCharacters())
                    }
            }
        }
    }

    fun deleteCharacter(character: Character) {
        viewModelScope.launch {
            characterUseCase.removeCharacter(character)

            _allCharacters.postValue(characterUseCase.getCharacters())
        }
    }

    fun saveCurrentCharacter() {
        runBlocking {
            saveCharacter(currentCharacter.value!!)
        }
    }

    private fun setProficiencyBonus(level: String) {
        if (level.isEmpty()) {
            currentCharacter.value?.proficiencyBonus = level
            return
        }

        val levelBase = level.toInt()
        val proficiencyBonus = (ceil(levelBase/4.0) + 1).toInt()
        val proficiencyBonusString = "+${proficiencyBonus}"
        currentCharacter.value?.proficiencyBonus = proficiencyBonusString
        this._proficiencyBonus.postValue(proficiencyBonusString)
    }

    private fun setStrengthBonus(strength: String) {
        if (strength.isEmpty()) {
            currentCharacter.value?.strengthBonus = strength
            updateStrengthBonuses(strength)
            return
        }
        val strengthBase = strength.toInt() - 10
        val strengthBonus = strengthBase / 2
        var strengthBonusString = strengthBonus.toString()
        if (!strengthBonusString.contains('-')) {
            strengthBonusString = "+$strengthBonusString"
        }
        currentCharacter.value?.strengthBonus = strengthBonusString
        updateStrengthBonuses(strengthBonusString)
    }

    private fun updateStrengthBonuses(strengthBonus: String) {
        currentCharacter.value?.let { currentCharacter ->
            currentCharacter.strengthSave = strengthBonus
            currentCharacter.athletics = strengthBonus
            saveCurrentCharacter()
            this._strengthBonus.postValue(strengthBonus)
        }
    }

    private fun setDexterityBonus(dexterity: String) {
        if (dexterity.isEmpty()) {
            currentCharacter.value?.dexterityBonus = dexterity
            updateDexterityBonuses(dexterity)
            return
        }
        val dexterityBase = dexterity.toInt() - 10
        val dexterityBonus = dexterityBase / 2
        var dexterityBonusString = dexterityBonus.toString()
        if (!dexterityBonusString.contains('-')) {
            dexterityBonusString = "+$dexterityBonusString"
        }
        currentCharacter.value?.dexterityBonus = dexterityBonusString
        updateDexterityBonuses(dexterityBonusString)
    }

    private fun updateDexterityBonuses(dexterityBonus: String) {
        currentCharacter.value?.let { currentCharacter ->
            currentCharacter.initiative = dexterityBonus
            currentCharacter.dexteritySave = dexterityBonus
            currentCharacter.acrobatics = dexterityBonus
            currentCharacter.sleightOfHand = dexterityBonus
            currentCharacter.stealth = dexterityBonus
            saveCurrentCharacter()
            this._dexterityBonus.postValue(dexterityBonus)
        }
    }

    private fun setConstitutionBonus(constitution: String) {
        if (constitution.isEmpty()) {
            currentCharacter.value?.constitutionBonus = constitution
            updateConstitutionBonuses(constitution)
            return
        }
        val constitutionBase = constitution.toInt() - 10
        val constitutionBonus = constitutionBase / 2
        var constitutionBonusString = constitutionBonus.toString()
        if (!constitutionBonusString.contains('-')) {
            constitutionBonusString = "+$constitutionBonusString"
        }
        currentCharacter.value?.constitutionBonus = constitutionBonusString
        updateConstitutionBonuses(constitutionBonusString)
    }

    private fun updateConstitutionBonuses(constitutionBonus: String) {
        currentCharacter.value?.let { currentCharacter ->
            currentCharacter.constitutionSave = constitutionBonus
            saveCurrentCharacter()
            this._constitutionBonus.postValue(constitutionBonus)
        }
    }

    private fun setIntelligenceBonus(intelligence: String) {
        if (intelligence.isEmpty()) {
            currentCharacter.value?.intelligenceBonus = intelligence
            updateIntelligenceBonuses(intelligence)
            return
        }
        val intelligenceBase = intelligence.toInt() - 10
        val intelligenceBonus = intelligenceBase / 2
        var intelligenceBonusString = intelligenceBonus.toString()
        if (!intelligenceBonusString.contains('-')) {
            intelligenceBonusString = "+$intelligenceBonusString"
        }
        currentCharacter.value?.intelligenceBonus = intelligenceBonusString
        updateIntelligenceBonuses(intelligenceBonusString)
    }

    private fun updateIntelligenceBonuses(intelligenceBonus: String) {
        currentCharacter.value?.let { currentCharacter ->
            currentCharacter.intelligenceSave = intelligenceBonus
            currentCharacter.arcana = intelligenceBonus
            currentCharacter.history = intelligenceBonus
            currentCharacter.investigation = intelligenceBonus
            currentCharacter.nature = intelligenceBonus
            currentCharacter.religion = intelligenceBonus
            saveCurrentCharacter()
            this._intelligenceBonus.postValue(intelligenceBonus)
        }
    }

    private fun setWisdomBonus(wisdom: String) {
        if (wisdom.isEmpty()) {
            currentCharacter.value?.wisdomBonus = wisdom
            updateWisdomBonuses(wisdom)
            return
        }
        val wisdomBase = wisdom.toInt() - 10
        val wisdomBonus = wisdomBase / 2
        var wisdomBonusString = wisdomBonus.toString()
        if (!wisdomBonusString.contains('-')) {
            wisdomBonusString = "+$wisdomBonusString"
        }
        currentCharacter.value?.wisdomBonus = wisdomBonusString
        updateWisdomBonuses(wisdomBonusString)
    }

    private fun updateWisdomBonuses(wisdomBonus: String) {
        currentCharacter.value?.let { currentCharacter ->
            currentCharacter.wisdomSave = wisdomBonus
            currentCharacter.animalHandling = wisdomBonus
            currentCharacter.insight = wisdomBonus
            currentCharacter.medicine = wisdomBonus
            currentCharacter.perception = wisdomBonus
            currentCharacter.survival = wisdomBonus
            saveCurrentCharacter()
            this._wisdomBonus.postValue(wisdomBonus)
        }
    }

    private fun setCharismaBonus(charisma: String) {
        if (charisma.isEmpty()) {
            currentCharacter.value?.charismaBonus = charisma
            updateCharismaBonuses(charisma)
            return
        }
        val charismaBase = charisma.toInt() - 10
        val charismaBonus = charismaBase / 2
        var charismaBonusString = charismaBonus.toString()
        if (!charismaBonusString.contains('-')) {
            charismaBonusString = "+$charismaBonusString"
        }
        currentCharacter.value?.charismaBonus = charismaBonusString
        updateCharismaBonuses(charismaBonusString)
    }

    private fun updateCharismaBonuses(charismaBonus: String) {
        currentCharacter.value?.let { currentCharacter ->
            currentCharacter.charismaSave = charismaBonus
            currentCharacter.deception = charismaBonus
            currentCharacter.intimidation = charismaBonus
            currentCharacter.performance = charismaBonus
            currentCharacter.persuasion = charismaBonus
            saveCurrentCharacter()
            this._charismaBonus.postValue(charismaBonus)
        }
    }

    override fun manualEditCompleted(view: View) {
        when (view) {
            is CSTextView -> {
                when (view.id) {
                    R.id.characterName -> currentCharacter.value?.characterName = view.text as String
                    R.id.classLevel -> currentCharacter.value?.classLevel = view.text as String
                    R.id.characterBackground -> currentCharacter.value?.background = view.text as String
                    R.id.playerName -> currentCharacter.value?.playerName = view.text as String
                    R.id.characterRace -> currentCharacter.value?.race= view.text as String
                    R.id.characterAlignment -> currentCharacter.value?.alignmentType = view.text as String
                    R.id.experiencePoints -> currentCharacter.value?.experiencePoints = view.text as String
                    R.id.totalLevel -> {
                        currentCharacter.value?.totalLevel = view.text as String
                        setProficiencyBonus(view.text as String)
                    }
                    R.id.armorClass -> currentCharacter.value?.armorClass = view.text as String
                    R.id.initiative -> currentCharacter.value?.initiative = view.text as String
                    R.id.speed -> currentCharacter.value?.speed = view.text as String
                    R.id.hitPointMax -> {
                        currentCharacter.value?.hitPointMax = view.text as String
                        currentCharacter.value?.currentHitPoints = view.text as String
                        this._currentHitPoint.postValue(view.text as String)
                    }
                    R.id.currentHitPoints -> currentCharacter.value?.currentHitPoints = view.text as String
                    R.id.tempHitPoints -> currentCharacter.value?.temporaryHitPoints = view.text as String
                    R.id.totalHitDice -> currentCharacter.value?.totalHitDice = view.text as String
                    R.id.hitDice -> currentCharacter.value?.hitDice = view.text as String
                    R.id.proficiencyBonus -> currentCharacter.value?.proficiencyBonus = view.text as String
                    R.id.strength -> {
                        currentCharacter.value?.strength = view.text as String
                        setStrengthBonus(view.text as String)
                    }
                    R.id.strengthBonus -> currentCharacter.value?.strengthBonus = view.text as String
                    R.id.dexterity -> {
                        currentCharacter.value?.dexterity = view.text as String
                        setDexterityBonus(view.text as String)
                    }
                    R.id.dexterityBonus -> currentCharacter.value?.dexterityBonus = view.text as String
                    R.id.constitution -> {
                        currentCharacter.value?.constitution = view.text as String
                        setConstitutionBonus(view.text as String)
                    }
                    R.id.constitutionBonus -> currentCharacter.value?.constitutionBonus = view.text as String
                    R.id.intelligence -> {
                        currentCharacter.value?.intelligence = view.text as String
                        setIntelligenceBonus(view.text as String)
                    }
                    R.id.intelligenceBonus -> currentCharacter.value?.intelligenceBonus = view.text as String
                    R.id.wisdom -> {
                        currentCharacter.value?.wisdom = view.text as String
                        setWisdomBonus(view.text as String)
                    }
                    R.id.wisdomBonus -> currentCharacter.value?.wisdomBonus = view.text as String
                    R.id.charisma -> {
                        currentCharacter.value?.charisma = view.text as String
                        setCharismaBonus(view.text as String)
                    }
                    R.id.charismaBonus -> currentCharacter.value?.charismaBonus = view.text as String
                    R.id.strengthSave -> currentCharacter.value?.strengthSave = view.text.toString()
                    R.id.dexteritySave -> currentCharacter.value?.dexteritySave = view.text as String
                    R.id.constitutionSave -> currentCharacter.value?.constitutionSave = view.text as String
                    R.id.intelligenceSave -> currentCharacter.value?.intelligenceSave = view.text as String
                    R.id.wisdomSave -> currentCharacter.value?.wisdomSave = view.text as String
                    R.id.charismaSave -> currentCharacter.value?.charismaSave = view.text as String
                    R.id.acrobatics -> currentCharacter.value?.acrobatics = view.text as String
                    R.id.animalHandling -> currentCharacter.value?.animalHandling = view.text as String
                    R.id.arcana -> currentCharacter.value?.arcana = view.text as String
                    R.id.athletics -> currentCharacter.value?.athletics = view.text as String
                    R.id.deception -> currentCharacter.value?.deception = view.text as String
                    R.id.history -> currentCharacter.value?.history = view.text as String
                    R.id.insight -> currentCharacter.value?.insight = view.text as String
                    R.id.intimidation -> currentCharacter.value?.intimidation = view.text as String
                    R.id.investigation -> currentCharacter.value?.investigation = view.text as String
                    R.id.medicine -> currentCharacter.value?.medicine = view.text as String
                    R.id.nature -> currentCharacter.value?.nature = view.text as String
                    R.id.perception -> currentCharacter.value?.perception = view.text as String
                    R.id.performance -> currentCharacter.value?.performance = view.text as String
                    R.id.persuasion -> currentCharacter.value?.persuasion = view.text as String
                    R.id.religion -> currentCharacter.value?.religion = view.text as String
                    R.id.sleightOfHand -> currentCharacter.value?.sleightOfHand = view.text as String
                    R.id.stealth -> currentCharacter.value?.stealth = view.text as String
                    R.id.survival -> currentCharacter.value?.survival = view.text as String
                    R.id.spellAttackName -> {
                        when (view.tag) {
                            "AttackName-0" -> currentCharacter.value?.attackSpells?.get(0)?.name = view.text as String
                            "AttackName-1" -> currentCharacter.value?.attackSpells?.get(1)?.name = view.text as String
                            "AttackName-2" -> currentCharacter.value?.attackSpells?.get(2)?.name = view.text as String
                            "AttackName-3" -> currentCharacter.value?.attackSpells?.get(3)?.name = view.text as String
                            "AttackName-4" -> currentCharacter.value?.attackSpells?.get(4)?.name = view.text as String
                            "AttackName-5" -> currentCharacter.value?.attackSpells?.get(5)?.name = view.text as String
                            "AttackName-6" -> currentCharacter.value?.attackSpells?.get(6)?.name = view.text as String
                            "AttackName-7" -> currentCharacter.value?.attackSpells?.get(7)?.name = view.text as String
                            "AttackName-8" -> currentCharacter.value?.attackSpells?.get(8)?.name = view.text as String
                            "AttackName-9" -> currentCharacter.value?.attackSpells?.get(9)?.name = view.text as String
                            "AttackName-10" -> currentCharacter.value?.attackSpells?.get(10)?.name = view.text as String
                            "AttackName-11" -> currentCharacter.value?.attackSpells?.get(11)?.name = view.text as String
                            "AttackName-12" -> currentCharacter.value?.attackSpells?.get(12)?.name = view.text as String
                            "AttackName-13" -> currentCharacter.value?.attackSpells?.get(13)?.name = view.text as String
                            "AttackName-14" -> currentCharacter.value?.attackSpells?.get(14)?.name = view.text as String
                            "AttackName-15" -> currentCharacter.value?.attackSpells?.get(15)?.name = view.text as String
                            "AttackName-16" -> currentCharacter.value?.attackSpells?.get(16)?.name = view.text as String
                            "AttackName-17" -> currentCharacter.value?.attackSpells?.get(17)?.name = view.text as String
                            "AttackName-18" -> currentCharacter.value?.attackSpells?.get(18)?.name = view.text as String
                            "AttackName-19" -> currentCharacter.value?.attackSpells?.get(19)?.name = view.text as String
                        }
                    }
                    R.id.spellAttackBonus -> {
                        when (view.tag) {
                            "AttackBonus-0" -> currentCharacter.value?.attackSpells?.get(0)?.attackBonus = view.text as String
                            "AttackBonus-1" -> currentCharacter.value?.attackSpells?.get(1)?.attackBonus = view.text as String
                            "AttackBonus-2" -> currentCharacter.value?.attackSpells?.get(2)?.attackBonus = view.text as String
                            "AttackBonus-3" -> currentCharacter.value?.attackSpells?.get(3)?.attackBonus = view.text as String
                            "AttackBonus-4" -> currentCharacter.value?.attackSpells?.get(4)?.attackBonus = view.text as String
                            "AttackBonus-5" -> currentCharacter.value?.attackSpells?.get(5)?.attackBonus = view.text as String
                            "AttackBonus-6" -> currentCharacter.value?.attackSpells?.get(6)?.attackBonus = view.text as String
                            "AttackBonus-7" -> currentCharacter.value?.attackSpells?.get(7)?.attackBonus = view.text as String
                            "AttackBonus-8" -> currentCharacter.value?.attackSpells?.get(8)?.attackBonus = view.text as String
                            "AttackBonus-9" -> currentCharacter.value?.attackSpells?.get(9)?.attackBonus = view.text as String
                            "AttackBonus-10" -> currentCharacter.value?.attackSpells?.get(10)?.attackBonus = view.text as String
                            "AttackBonus-11" -> currentCharacter.value?.attackSpells?.get(11)?.attackBonus = view.text as String
                            "AttackBonus-12" -> currentCharacter.value?.attackSpells?.get(12)?.attackBonus = view.text as String
                            "AttackBonus-13" -> currentCharacter.value?.attackSpells?.get(13)?.attackBonus = view.text as String
                            "AttackBonus-14" -> currentCharacter.value?.attackSpells?.get(14)?.attackBonus = view.text as String
                            "AttackBonus-15" -> currentCharacter.value?.attackSpells?.get(15)?.attackBonus = view.text as String
                            "AttackBonus-16" -> currentCharacter.value?.attackSpells?.get(16)?.attackBonus = view.text as String
                            "AttackBonus-17" -> currentCharacter.value?.attackSpells?.get(17)?.attackBonus = view.text as String
                            "AttackBonus-18" -> currentCharacter.value?.attackSpells?.get(18)?.attackBonus = view.text as String
                            "AttackBonus-19" -> currentCharacter.value?.attackSpells?.get(19)?.attackBonus = view.text as String
                        }
                    }
                    R.id.spellAttackType -> {
                        when (view.tag) {
                            "AttackType-0" -> currentCharacter.value?.attackSpells?.get(0)?.damageType = view.text as String
                            "AttackType-1" -> currentCharacter.value?.attackSpells?.get(1)?.damageType = view.text as String
                            "AttackType-2" -> currentCharacter.value?.attackSpells?.get(2)?.damageType = view.text as String
                            "AttackType-3" -> currentCharacter.value?.attackSpells?.get(3)?.damageType = view.text as String
                            "AttackType-4" -> currentCharacter.value?.attackSpells?.get(4)?.damageType = view.text as String
                            "AttackType-5" -> currentCharacter.value?.attackSpells?.get(5)?.damageType = view.text as String
                            "AttackType-6" -> currentCharacter.value?.attackSpells?.get(6)?.damageType = view.text as String
                            "AttackType-7" -> currentCharacter.value?.attackSpells?.get(7)?.damageType = view.text as String
                            "AttackType-8" -> currentCharacter.value?.attackSpells?.get(8)?.damageType = view.text as String
                            "AttackType-9" -> currentCharacter.value?.attackSpells?.get(9)?.damageType = view.text as String
                            "AttackType-10" -> currentCharacter.value?.attackSpells?.get(10)?.damageType = view.text as String
                            "AttackType-11" -> currentCharacter.value?.attackSpells?.get(11)?.damageType = view.text as String
                            "AttackType-12" -> currentCharacter.value?.attackSpells?.get(12)?.damageType = view.text as String
                            "AttackType-13" -> currentCharacter.value?.attackSpells?.get(13)?.damageType = view.text as String
                            "AttackType-14" -> currentCharacter.value?.attackSpells?.get(14)?.damageType = view.text as String
                            "AttackType-15" -> currentCharacter.value?.attackSpells?.get(15)?.damageType = view.text as String
                            "AttackType-16" -> currentCharacter.value?.attackSpells?.get(16)?.damageType = view.text as String
                            "AttackType-17" -> currentCharacter.value?.attackSpells?.get(17)?.damageType = view.text as String
                            "AttackType-18" -> currentCharacter.value?.attackSpells?.get(18)?.damageType = view.text as String
                            "AttackType-19" -> currentCharacter.value?.attackSpells?.get(19)?.damageType = view.text as String
                        }
                    }
                    R.id.copperPieces -> currentCharacter.value?.copper = view.text.toString()
                    R.id.silverPieces -> currentCharacter.value?.silver = view.text as String
                    R.id.electrumPieces -> currentCharacter.value?.electrum = view.text as String
                    R.id.goldPieces -> currentCharacter.value?.gold = view.text as String
                    R.id.platinumPieces -> currentCharacter.value?.platinum = view.text as String

                    R.id.spellcastingClass -> currentCharacter.value?.spellCastingClass = view.text as String
                    R.id.spellcastingAbility -> currentCharacter.value?.spellCastingAbility = view.text as String
                    R.id.spellSaveDC -> currentCharacter.value?.spellSaveDC = view.text as String
                    R.id.spellBonus -> currentCharacter.value?.spellAttackBonus = view.text as String
                    R.id.cantripName -> {
                        when (view.tag) {
                            "Cantrip1" -> currentCharacter.value?.cantrips?.set(0, view.text as String)
                            "Cantrip2" -> currentCharacter.value?.cantrips?.set(1, view.text as String)
                            "Cantrip3" -> currentCharacter.value?.cantrips?.set(2, view.text as String)
                            "Cantrip4" -> currentCharacter.value?.cantrips?.set(3, view.text as String)
                            "Cantrip5" -> currentCharacter.value?.cantrips?.set(4, view.text as String)
                            "Cantrip6" -> currentCharacter.value?.cantrips?.set(5, view.text as String)
                            "Cantrip7" -> currentCharacter.value?.cantrips?.set(6, view.text as String)
                            "Cantrip8" -> currentCharacter.value?.cantrips?.set(7, view.text as String)
                        }
                    }
                    R.id.level1SlotsTotal -> currentCharacter.value?.spells?.get(0)?.totalSpellSlots =
                        view.text as String
                    R.id.level1SlotsExpended -> currentCharacter.value?.spells?.get(0)?.spellSlotsExpended =
                        view.text as String
                    R.id.level2SlotsTotal -> currentCharacter.value?.spells?.get(1)?.totalSpellSlots =
                        view.text as String
                    R.id.level2SlotsExpended -> currentCharacter.value?.spells?.get(1)?.spellSlotsExpended =
                        view.text as String
                    R.id.level3SlotsTotal -> currentCharacter.value?.spells?.get(2)?.totalSpellSlots =
                        view.text as String
                    R.id.level3SlotsExpended -> currentCharacter.value?.spells?.get(2)?.spellSlotsExpended =
                        view.text as String
                    R.id.level4SlotsTotal -> currentCharacter.value?.spells?.get(3)?.totalSpellSlots =
                        view.text as String
                    R.id.level4SlotsExpended -> currentCharacter.value?.spells?.get(3)?.spellSlotsExpended =
                        view.text as String
                    R.id.level5SlotsTotal -> currentCharacter.value?.spells?.get(4)?.totalSpellSlots =
                        view.text as String
                    R.id.level5SlotsExpended -> currentCharacter.value?.spells?.get(4)?.spellSlotsExpended =
                        view.text as String
                    R.id.level6SlotsTotal -> currentCharacter.value?.spells?.get(5)?.totalSpellSlots =
                        view.text as String
                    R.id.level6SlotsExpended -> currentCharacter.value?.spells?.get(5)?.spellSlotsExpended =
                        view.text as String
                    R.id.level7SlotsTotal -> currentCharacter.value?.spells?.get(6)?.totalSpellSlots =
                        view.text as String
                    R.id.level7SlotsExpended -> currentCharacter.value?.spells?.get(6)?.spellSlotsExpended =
                        view.text as String
                    R.id.level8SlotsTotal -> currentCharacter.value?.spells?.get(7)?.totalSpellSlots =
                        view.text as String
                    R.id.level8SlotsExpended -> currentCharacter.value?.spells?.get(7)?.spellSlotsExpended =
                        view.text as String
                    R.id.level9SlotsTotal -> currentCharacter.value?.spells?.get(8)?.totalSpellSlots =
                        view.text as String
                    R.id.level9SlotsExpended -> currentCharacter.value?.spells?.get(8)?.spellSlotsExpended =
                        view.text as String
                    R.id.spellName -> {
                        when (view.tag) {
                            "SpellName1-1" -> currentCharacter.value?.spells?.get(0)?.spellName?.set(0,
                                view.text as String
                            )
                            "SpellName1-2" -> currentCharacter.value?.spells?.get(0)?.spellName?.set(1,
                                view.text as String
                            )
                            "SpellName1-3" -> currentCharacter.value?.spells?.get(0)?.spellName?.set(2,
                                view.text as String
                            )
                            "SpellName1-4" -> currentCharacter.value?.spells?.get(0)?.spellName?.set(3,
                                view.text as String
                            )
                            "SpellName1-5" -> currentCharacter.value?.spells?.get(0)?.spellName?.set(4,
                                view.text as String
                            )
                            "SpellName1-6" -> currentCharacter.value?.spells?.get(0)?.spellName?.set(5,
                                view.text as String
                            )
                            "SpellName1-7" -> currentCharacter.value?.spells?.get(0)?.spellName?.set(6,
                                view.text as String
                            )
                            "SpellName1-8" -> currentCharacter.value?.spells?.get(0)?.spellName?.set(7,
                                view.text as String
                            )
                            "SpellName1-9" -> currentCharacter.value?.spells?.get(0)?.spellName?.set(8,
                                view.text as String
                            )
                            "SpellName1-10" -> currentCharacter.value?.spells?.get(0)?.spellName?.set(9,
                                view.text as String
                            )
                            "SpellName1-11" -> currentCharacter.value?.spells?.get(0)?.spellName?.set(10,
                                view.text as String
                            )
                            "SpellName1-12" -> currentCharacter.value?.spells?.get(0)?.spellName?.set(11,
                                view.text as String
                            )
                            "SpellName1-13" -> currentCharacter.value?.spells?.get(0)?.spellName?.set(12,
                                view.text as String
                            )
                            "SpellName2-1" -> currentCharacter.value?.spells?.get(1)?.spellName?.set(0,
                                view.text as String
                            )
                            "SpellName2-2" -> currentCharacter.value?.spells?.get(1)?.spellName?.set(1,
                                view.text as String
                            )
                            "SpellName2-3" -> currentCharacter.value?.spells?.get(1)?.spellName?.set(2,
                                view.text as String
                            )
                            "SpellName2-4" -> currentCharacter.value?.spells?.get(1)?.spellName?.set(3,
                                view.text as String
                            )
                            "SpellName2-5" -> currentCharacter.value?.spells?.get(1)?.spellName?.set(4,
                                view.text as String
                            )
                            "SpellName2-6" -> currentCharacter.value?.spells?.get(1)?.spellName?.set(5,
                                view.text as String
                            )
                            "SpellName2-7" -> currentCharacter.value?.spells?.get(1)?.spellName?.set(6,
                                view.text as String
                            )
                            "SpellName2-8" -> currentCharacter.value?.spells?.get(1)?.spellName?.set(7,
                                view.text as String
                            )
                            "SpellName2-9" -> currentCharacter.value?.spells?.get(1)?.spellName?.set(8,
                                view.text as String
                            )
                            "SpellName2-10" -> currentCharacter.value?.spells?.get(1)?.spellName?.set(9,
                                view.text as String
                            )
                            "SpellName2-11" -> currentCharacter.value?.spells?.get(1)?.spellName?.set(10,
                                view.text as String
                            )
                            "SpellName2-12" -> currentCharacter.value?.spells?.get(1)?.spellName?.set(11,
                                view.text as String
                            )
                            "SpellName2-13" -> currentCharacter.value?.spells?.get(1)?.spellName?.set(12,
                                view.text as String
                            )
                            "SpellName3-1" -> currentCharacter.value?.spells?.get(2)?.spellName?.set(0,
                                view.text as String
                            )
                            "SpellName3-2" -> currentCharacter.value?.spells?.get(2)?.spellName?.set(1,
                                view.text as String
                            )
                            "SpellName3-3" -> currentCharacter.value?.spells?.get(2)?.spellName?.set(2,
                                view.text as String
                            )
                            "SpellName3-4" -> currentCharacter.value?.spells?.get(2)?.spellName?.set(3,
                                view.text as String
                            )
                            "SpellName3-5" -> currentCharacter.value?.spells?.get(2)?.spellName?.set(4,
                                view.text as String
                            )
                            "SpellName3-6" -> currentCharacter.value?.spells?.get(2)?.spellName?.set(5,
                                view.text as String
                            )
                            "SpellName3-7" -> currentCharacter.value?.spells?.get(2)?.spellName?.set(6,
                                view.text as String
                            )
                            "SpellName3-8" -> currentCharacter.value?.spells?.get(2)?.spellName?.set(7,
                                view.text as String
                            )
                            "SpellName3-9" -> currentCharacter.value?.spells?.get(2)?.spellName?.set(8,
                                view.text as String
                            )
                            "SpellName3-10" -> currentCharacter.value?.spells?.get(2)?.spellName?.set(9,
                                view.text as String
                            )
                            "SpellName3-11" -> currentCharacter.value?.spells?.get(2)?.spellName?.set(10,
                                view.text as String
                            )
                            "SpellName3-12" -> currentCharacter.value?.spells?.get(2)?.spellName?.set(11,
                                view.text as String
                            )
                            "SpellName3-13" -> currentCharacter.value?.spells?.get(2)?.spellName?.set(12,
                                view.text as String
                            )
                            "SpellName4-1" -> currentCharacter.value?.spells?.get(3)?.spellName?.set(0,
                                view.text as String
                            )
                            "SpellName4-2" -> currentCharacter.value?.spells?.get(3)?.spellName?.set(1,
                                view.text as String
                            )
                            "SpellName4-3" -> currentCharacter.value?.spells?.get(3)?.spellName?.set(2,
                                view.text as String
                            )
                            "SpellName4-4" -> currentCharacter.value?.spells?.get(3)?.spellName?.set(3,
                                view.text as String
                            )
                            "SpellName4-5" -> currentCharacter.value?.spells?.get(3)?.spellName?.set(4,
                                view.text as String
                            )
                            "SpellName4-6" -> currentCharacter.value?.spells?.get(3)?.spellName?.set(5,
                                view.text as String
                            )
                            "SpellName4-7" -> currentCharacter.value?.spells?.get(3)?.spellName?.set(6,
                                view.text as String
                            )
                            "SpellName4-8" -> currentCharacter.value?.spells?.get(3)?.spellName?.set(7,
                                view.text as String
                            )
                            "SpellName4-9" -> currentCharacter.value?.spells?.get(3)?.spellName?.set(8,
                                view.text as String
                            )
                            "SpellName4-10" -> currentCharacter.value?.spells?.get(3)?.spellName?.set(9,
                                view.text as String
                            )
                            "SpellName4-11" -> currentCharacter.value?.spells?.get(3)?.spellName?.set(10,
                                view.text as String
                            )
                            "SpellName4-12" -> currentCharacter.value?.spells?.get(3)?.spellName?.set(11,
                                view.text as String
                            )
                            "SpellName4-13" -> currentCharacter.value?.spells?.get(3)?.spellName?.set(12,
                                view.text as String
                            )
                            "SpellName5-1" -> currentCharacter.value?.spells?.get(4)?.spellName?.set(0,
                                view.text as String
                            )
                            "SpellName5-2" -> currentCharacter.value?.spells?.get(4)?.spellName?.set(1,
                                view.text as String
                            )
                            "SpellName5-3" -> currentCharacter.value?.spells?.get(4)?.spellName?.set(2,
                                view.text as String
                            )
                            "SpellName5-4" -> currentCharacter.value?.spells?.get(4)?.spellName?.set(3,
                                view.text as String
                            )
                            "SpellName5-5" -> currentCharacter.value?.spells?.get(4)?.spellName?.set(4,
                                view.text as String
                            )
                            "SpellName5-6" -> currentCharacter.value?.spells?.get(4)?.spellName?.set(5,
                                view.text as String
                            )
                            "SpellName5-7" -> currentCharacter.value?.spells?.get(4)?.spellName?.set(6,
                                view.text as String
                            )
                            "SpellName5-8" -> currentCharacter.value?.spells?.get(4)?.spellName?.set(7,
                                view.text as String
                            )
                            "SpellName5-9" -> currentCharacter.value?.spells?.get(4)?.spellName?.set(8,
                                view.text as String
                            )
                            "SpellName5-10" -> currentCharacter.value?.spells?.get(4)?.spellName?.set(9,
                                view.text as String
                            )
                            "SpellName5-11" -> currentCharacter.value?.spells?.get(4)?.spellName?.set(10,
                                view.text as String
                            )
                            "SpellName6-1" -> currentCharacter.value?.spells?.get(5)?.spellName?.set(0,
                                view.text as String
                            )
                            "SpellName6-2" -> currentCharacter.value?.spells?.get(5)?.spellName?.set(1,
                                view.text as String
                            )
                            "SpellName6-3" -> currentCharacter.value?.spells?.get(5)?.spellName?.set(2,
                                view.text as String
                            )
                            "SpellName6-4" -> currentCharacter.value?.spells?.get(5)?.spellName?.set(3,
                                view.text as String
                            )
                            "SpellName6-5" -> currentCharacter.value?.spells?.get(5)?.spellName?.set(4,
                                view.text as String
                            )
                            "SpellName6-6" -> currentCharacter.value?.spells?.get(5)?.spellName?.set(5,
                                view.text as String
                            )
                            "SpellName6-7" -> currentCharacter.value?.spells?.get(5)?.spellName?.set(6,
                                view.text as String
                            )
                            "SpellName6-8" -> currentCharacter.value?.spells?.get(5)?.spellName?.set(7,
                                view.text as String
                            )
                            "SpellName6-9" -> currentCharacter.value?.spells?.get(5)?.spellName?.set(8,
                                view.text as String
                            )
                            "SpellName6-10" -> currentCharacter.value?.spells?.get(5)?.spellName?.set(9,
                                view.text as String
                            )
                            "SpellName6-11" -> currentCharacter.value?.spells?.get(5)?.spellName?.set(10,
                                view.text as String
                            )
                            "SpellName7-1" -> currentCharacter.value?.spells?.get(6)?.spellName?.set(0,
                                view.text as String
                            )
                            "SpellName7-2" -> currentCharacter.value?.spells?.get(6)?.spellName?.set(1,
                                view.text as String
                            )
                            "SpellName7-3" -> currentCharacter.value?.spells?.get(6)?.spellName?.set(2,
                                view.text as String
                            )
                            "SpellName7-4" -> currentCharacter.value?.spells?.get(6)?.spellName?.set(3,
                                view.text as String
                            )
                            "SpellName7-5" -> currentCharacter.value?.spells?.get(6)?.spellName?.set(4,
                                view.text as String
                            )
                            "SpellName7-6" -> currentCharacter.value?.spells?.get(6)?.spellName?.set(5,
                                view.text as String
                            )
                            "SpellName7-7" -> currentCharacter.value?.spells?.get(6)?.spellName?.set(6,
                                view.text as String
                            )
                            "SpellName7-8" -> currentCharacter.value?.spells?.get(6)?.spellName?.set(7,
                                view.text as String
                            )
                            "SpellName7-9" -> currentCharacter.value?.spells?.get(6)?.spellName?.set(8,
                                view.text as String
                            )
                            "SpellName7-10" -> currentCharacter.value?.spells?.get(6)?.spellName?.set(9,
                                view.text as String
                            )
                            "SpellName7-11" -> currentCharacter.value?.spells?.get(6)?.spellName?.set(10,
                                view.text as String
                            )
                            "SpellName8-1" -> currentCharacter.value?.spells?.get(7)?.spellName?.set(0,
                                view.text as String
                            )
                            "SpellName8-2" -> currentCharacter.value?.spells?.get(7)?.spellName?.set(1,
                                view.text as String
                            )
                            "SpellName8-3" -> currentCharacter.value?.spells?.get(7)?.spellName?.set(2,
                                view.text as String
                            )
                            "SpellName8-4" -> currentCharacter.value?.spells?.get(7)?.spellName?.set(3,
                                view.text as String
                            )
                            "SpellName8-5" -> currentCharacter.value?.spells?.get(7)?.spellName?.set(4,
                                view.text as String
                            )
                            "SpellName8-6" -> currentCharacter.value?.spells?.get(7)?.spellName?.set(5,
                                view.text as String
                            )
                            "SpellName8-7" -> currentCharacter.value?.spells?.get(7)?.spellName?.set(6,
                                view.text as String
                            )
                            "SpellName8-8" -> currentCharacter.value?.spells?.get(7)?.spellName?.set(7,
                                view.text as String
                            )
                            "SpellName8-9" -> currentCharacter.value?.spells?.get(7)?.spellName?.set(8,
                                view.text as String
                            )
                            "SpellName9-1" -> currentCharacter.value?.spells?.get(8)?.spellName?.set(0,
                                view.text as String
                            )
                            "SpellName9-2" -> currentCharacter.value?.spells?.get(8)?.spellName?.set(1,
                                view.text as String
                            )
                            "SpellName9-3" -> currentCharacter.value?.spells?.get(8)?.spellName?.set(2,
                                view.text as String
                            )
                            "SpellName9-4" -> currentCharacter.value?.spells?.get(8)?.spellName?.set(3,
                                view.text as String
                            )
                            "SpellName9-5" -> currentCharacter.value?.spells?.get(8)?.spellName?.set(4,
                                view.text as String
                            )
                            "SpellName9-6" -> currentCharacter.value?.spells?.get(8)?.spellName?.set(5,
                                view.text as String
                            )
                            "SpellName9-7" -> currentCharacter.value?.spells?.get(8)?.spellName?.set(6,
                                view.text as String
                            )
                            "SpellName9-8" -> currentCharacter.value?.spells?.get(8)?.spellName?.set(7,
                                view.text as String
                            )
                            "SpellName9-9" -> currentCharacter.value?.spells?.get(8)?.spellName?.set(8,
                                view.text as String
                            )
                        }
                    }
                }
            }
            is CSTextViewLong -> {
                when (view.id) {
                    R.id.equipment -> currentCharacter.value?.equipment = view.text as String
                    R.id.proficienciesLanguages -> currentCharacter.value?.proficiencyLanguages = view.text as String
                    R.id.personalityTraits -> currentCharacter.value?.personalityTraits = view.text as String
                    R.id.ideals -> currentCharacter.value?.ideals = view.text as String
                    R.id.bonds -> currentCharacter.value?.bonds = view.text as String
                    R.id.flaws -> currentCharacter.value?.flaws = view.text as String
                    R.id.notesMisc -> currentCharacter.value?.notesMisc = view.text as String
                }
            }
            is CSCheckbox -> {
                when (view.id) {
                    R.id.successSaveButton1 -> currentCharacter.value?.successDeathSave1 = view.isChecked
                    R.id.successSaveButton2 -> currentCharacter.value?.successDeathSave2 = view.isChecked
                    R.id.successSaveButton3 -> currentCharacter.value?.successDeathSave3 = view.isChecked
                    R.id.failSaveButton1 -> currentCharacter.value?.failDeathSave1 = view.isChecked
                    R.id.failSaveButton2 -> currentCharacter.value?.failDeathSave2 = view.isChecked
                    R.id.failSaveButton3 -> currentCharacter.value?.failDeathSave3 = view.isChecked
                    R.id.strengthSaveButton -> currentCharacter.value?.strengthSaveChecked = view.isChecked
                    R.id.dexteritySaveButton -> currentCharacter.value?.dexteritySaveChecked = view.isChecked
                    R.id.constitutionSaveButton -> currentCharacter.value?.constitutionSaveChecked = view.isChecked
                    R.id.intelligenceSaveButton -> currentCharacter.value?.intelligenceSaveChecked = view.isChecked
                    R.id.wisdomSaveButton -> currentCharacter.value?.wisdomSaveChecked = view.isChecked
                    R.id.charismaSaveButton -> currentCharacter.value?.charismaSaveChecked = view.isChecked
                    R.id.acrobaticsButton -> currentCharacter.value?.acrobaticsChecked = view.isChecked
                    R.id.animalHandlingButton -> currentCharacter.value?.animalHandlingChecked = view.isChecked
                    R.id.arcanaButton -> currentCharacter.value?.arcanaChecked = view.isChecked
                    R.id.athleticsButton -> currentCharacter.value?.athleticsChecked = view.isChecked
                    R.id.deceptionButton -> currentCharacter.value?.deceptionChecked = view.isChecked
                    R.id.historyButton -> currentCharacter.value?.historyChecked = view.isChecked
                    R.id.insightButton -> currentCharacter.value?.insightChecked = view.isChecked
                    R.id.intimidationButton -> currentCharacter.value?.intimidationChecked = view.isChecked
                    R.id.investigationButton -> currentCharacter.value?.investigationChecked = view.isChecked
                    R.id.medicineButton -> currentCharacter.value?.medicineChecked = view.isChecked
                    R.id.natureButton -> currentCharacter.value?.natureChecked = view.isChecked
                    R.id.perceptionButton -> currentCharacter.value?.perceptionChecked = view.isChecked
                    R.id.performanceButton -> currentCharacter.value?.performanceChecked = view.isChecked
                    R.id.persuasionButton -> currentCharacter.value?.persuasionChecked = view.isChecked
                    R.id.religionButton -> currentCharacter.value?.religionChecked = view.isChecked
                    R.id.sleightOfHandButton -> currentCharacter.value?.sleightOfHandChecked = view.isChecked
                    R.id.stealthButton -> currentCharacter.value?.stealthChecked = view.isChecked
                    R.id.survivalButton -> currentCharacter.value?.survivalChecked = view.isChecked
                    R.id.spellButton -> {
                        when (view.tag) {
                            "SpellButton1-1" -> currentCharacter.value?.spells?.get(0)?.spellChecked?.set(0,
                                view.isChecked
                            )
                            "SpellButton1-2" -> currentCharacter.value?.spells?.get(0)?.spellChecked?.set(1,
                                view.isChecked
                            )
                            "SpellButton1-3" -> currentCharacter.value?.spells?.get(0)?.spellChecked?.set(2,
                                view.isChecked
                            )
                            "SpellButton1-4" -> currentCharacter.value?.spells?.get(0)?.spellChecked?.set(3,
                                view.isChecked
                            )
                            "SpellButton1-5" -> currentCharacter.value?.spells?.get(0)?.spellChecked?.set(4,
                                view.isChecked
                            )
                            "SpellButton1-6" -> currentCharacter.value?.spells?.get(0)?.spellChecked?.set(5,
                                view.isChecked
                            )
                            "SpellButton1-7" -> currentCharacter.value?.spells?.get(0)?.spellChecked?.set(6,
                                view.isChecked
                            )
                            "SpellButton1-8" -> currentCharacter.value?.spells?.get(0)?.spellChecked?.set(7,
                                view.isChecked
                            )
                            "SpellButton1-9" -> currentCharacter.value?.spells?.get(0)?.spellChecked?.set(8,
                                view.isChecked
                            )
                            "SpellButton1-10" -> currentCharacter.value?.spells?.get(0)?.spellChecked?.set(9,
                                view.isChecked
                            )
                            "SpellButton1-11" -> currentCharacter.value?.spells?.get(0)?.spellChecked?.set(10,
                                view.isChecked
                            )
                            "SpellButton1-12" -> currentCharacter.value?.spells?.get(0)?.spellChecked?.set(11,
                                view.isChecked
                            )
                            "SpellButton1-13" -> currentCharacter.value?.spells?.get(0)?.spellChecked?.set(12,
                                view.isChecked
                            )
                            "SpellButton2-1" -> currentCharacter.value?.spells?.get(1)?.spellChecked?.set(0,
                                view.isChecked
                            )
                            "SpellButton2-2" -> currentCharacter.value?.spells?.get(1)?.spellChecked?.set(1,
                                view.isChecked
                            )
                            "SpellButton2-3" -> currentCharacter.value?.spells?.get(1)?.spellChecked?.set(2,
                                view.isChecked
                            )
                            "SpellButton2-4" -> currentCharacter.value?.spells?.get(1)?.spellChecked?.set(3,
                                view.isChecked
                            )
                            "SpellButton2-5" -> currentCharacter.value?.spells?.get(1)?.spellChecked?.set(4,
                                view.isChecked
                            )
                            "SpellButton2-6" -> currentCharacter.value?.spells?.get(1)?.spellChecked?.set(5,
                                view.isChecked
                            )
                            "SpellButton2-7" -> currentCharacter.value?.spells?.get(1)?.spellChecked?.set(6,
                                view.isChecked
                            )
                            "SpellButton2-8" -> currentCharacter.value?.spells?.get(1)?.spellChecked?.set(7,
                                view.isChecked
                            )
                            "SpellButton2-9" -> currentCharacter.value?.spells?.get(1)?.spellChecked?.set(8,
                                view.isChecked
                            )
                            "SpellButton2-10" -> currentCharacter.value?.spells?.get(1)?.spellChecked?.set(9,
                                view.isChecked
                            )
                            "SpellButton2-11" -> currentCharacter.value?.spells?.get(1)?.spellChecked?.set(10,
                                view.isChecked
                            )
                            "SpellButton2-12" -> currentCharacter.value?.spells?.get(1)?.spellChecked?.set(11,
                                view.isChecked
                            )
                            "SpellButton2-13" -> currentCharacter.value?.spells?.get(1)?.spellChecked?.set(12,
                                view.isChecked
                            )
                            "SpellButton3-1" -> currentCharacter.value?.spells?.get(2)?.spellChecked?.set(0,
                                view.isChecked
                            )
                            "SpellButton3-2" -> currentCharacter.value?.spells?.get(2)?.spellChecked?.set(1,
                                view.isChecked
                            )
                            "SpellButton3-3" -> currentCharacter.value?.spells?.get(2)?.spellChecked?.set(2,
                                view.isChecked
                            )
                            "SpellButton3-4" -> currentCharacter.value?.spells?.get(2)?.spellChecked?.set(3,
                                view.isChecked
                            )
                            "SpellButton3-5" -> currentCharacter.value?.spells?.get(2)?.spellChecked?.set(4,
                                view.isChecked
                            )
                            "SpellButton3-6" -> currentCharacter.value?.spells?.get(2)?.spellChecked?.set(5,
                                view.isChecked
                            )
                            "SpellButton3-7" -> currentCharacter.value?.spells?.get(2)?.spellChecked?.set(6,
                                view.isChecked
                            )
                            "SpellButton3-8" -> currentCharacter.value?.spells?.get(2)?.spellChecked?.set(7,
                                view.isChecked
                            )
                            "SpellButton3-9" -> currentCharacter.value?.spells?.get(2)?.spellChecked?.set(8,
                                view.isChecked
                            )
                            "SpellButton3-10" -> currentCharacter.value?.spells?.get(2)?.spellChecked?.set(9,
                                view.isChecked
                            )
                            "SpellButton3-11" -> currentCharacter.value?.spells?.get(2)?.spellChecked?.set(10,
                                view.isChecked
                            )
                            "SpellButton3-12" -> currentCharacter.value?.spells?.get(2)?.spellChecked?.set(11,
                                view.isChecked
                            )
                            "SpellButton3-13" -> currentCharacter.value?.spells?.get(2)?.spellChecked?.set(12,
                                view.isChecked
                            )
                            "SpellButton4-1" -> currentCharacter.value?.spells?.get(3)?.spellChecked?.set(0,
                                view.isChecked
                            )
                            "SpellButton4-2" -> currentCharacter.value?.spells?.get(3)?.spellChecked?.set(1,
                                view.isChecked
                            )
                            "SpellButton4-3" -> currentCharacter.value?.spells?.get(3)?.spellChecked?.set(2,
                                view.isChecked
                            )
                            "SpellButton4-4" -> currentCharacter.value?.spells?.get(3)?.spellChecked?.set(3,
                                view.isChecked
                            )
                            "SpellButton4-5" -> currentCharacter.value?.spells?.get(3)?.spellChecked?.set(4,
                                view.isChecked
                            )
                            "SpellButton4-6" -> currentCharacter.value?.spells?.get(3)?.spellChecked?.set(5,
                                view.isChecked
                            )
                            "SpellButton4-7" -> currentCharacter.value?.spells?.get(3)?.spellChecked?.set(6,
                                view.isChecked
                            )
                            "SpellButton4-8" -> currentCharacter.value?.spells?.get(3)?.spellChecked?.set(7,
                                view.isChecked
                            )
                            "SpellButton4-9" -> currentCharacter.value?.spells?.get(3)?.spellChecked?.set(8,
                                view.isChecked
                            )
                            "SpellButton4-10" -> currentCharacter.value?.spells?.get(3)?.spellChecked?.set(9,
                                view.isChecked
                            )
                            "SpellButton4-11" -> currentCharacter.value?.spells?.get(3)?.spellChecked?.set(10,
                                view.isChecked
                            )
                            "SpellButton4-12" -> currentCharacter.value?.spells?.get(3)?.spellChecked?.set(11,
                                view.isChecked
                            )
                            "SpellButton4-13" -> currentCharacter.value?.spells?.get(3)?.spellChecked?.set(12,
                                view.isChecked
                            )
                            "SpellButton5-1" -> currentCharacter.value?.spells?.get(4)?.spellChecked?.set(0,
                                view.isChecked
                            )
                            "SpellButton5-2" -> currentCharacter.value?.spells?.get(4)?.spellChecked?.set(1,
                                view.isChecked
                            )
                            "SpellButton5-3" -> currentCharacter.value?.spells?.get(4)?.spellChecked?.set(2,
                                view.isChecked
                            )
                            "SpellButton5-4" -> currentCharacter.value?.spells?.get(4)?.spellChecked?.set(3,
                                view.isChecked
                            )
                            "SpellButton5-5" -> currentCharacter.value?.spells?.get(4)?.spellChecked?.set(4,
                                view.isChecked
                            )
                            "SpellButton5-6" -> currentCharacter.value?.spells?.get(4)?.spellChecked?.set(5,
                                view.isChecked
                            )
                            "SpellButton5-7" -> currentCharacter.value?.spells?.get(4)?.spellChecked?.set(6,
                                view.isChecked
                            )
                            "SpellButton5-8" -> currentCharacter.value?.spells?.get(4)?.spellChecked?.set(7,
                                view.isChecked
                            )
                            "SpellButton5-9" -> currentCharacter.value?.spells?.get(4)?.spellChecked?.set(8,
                                view.isChecked
                            )
                            "SpellButton5-10" -> currentCharacter.value?.spells?.get(4)?.spellChecked?.set(9,
                                view.isChecked
                            )
                            "SpellButton5-11" -> currentCharacter.value?.spells?.get(4)?.spellChecked?.set(10,
                                view.isChecked
                            )
                            "SpellButton6-1" -> currentCharacter.value?.spells?.get(5)?.spellChecked?.set(0,
                                view.isChecked
                            )
                            "SpellButton6-2" -> currentCharacter.value?.spells?.get(5)?.spellChecked?.set(1,
                                view.isChecked
                            )
                            "SpellButton6-3" -> currentCharacter.value?.spells?.get(5)?.spellChecked?.set(2,
                                view.isChecked
                            )
                            "SpellButton6-4" -> currentCharacter.value?.spells?.get(5)?.spellChecked?.set(3,
                                view.isChecked
                            )
                            "SpellButton6-5" -> currentCharacter.value?.spells?.get(5)?.spellChecked?.set(4,
                                view.isChecked
                            )
                            "SpellButton6-6" -> currentCharacter.value?.spells?.get(5)?.spellChecked?.set(5,
                                view.isChecked
                            )
                            "SpellButton6-7" -> currentCharacter.value?.spells?.get(5)?.spellChecked?.set(6,
                                view.isChecked
                            )
                            "SpellButton6-8" -> currentCharacter.value?.spells?.get(5)?.spellChecked?.set(7,
                                view.isChecked
                            )
                            "SpellButton6-9" -> currentCharacter.value?.spells?.get(5)?.spellChecked?.set(8,
                                view.isChecked
                            )
                            "SpellButton6-10" -> currentCharacter.value?.spells?.get(5)?.spellChecked?.set(9,
                                view.isChecked
                            )
                            "SpellButton6-11" -> currentCharacter.value?.spells?.get(5)?.spellChecked?.set(10,
                                view.isChecked
                            )
                            "SpellButton7-1" -> currentCharacter.value?.spells?.get(6)?.spellChecked?.set(0,
                                view.isChecked
                            )
                            "SpellButton7-2" -> currentCharacter.value?.spells?.get(6)?.spellChecked?.set(1,
                                view.isChecked
                            )
                            "SpellButton7-3" -> currentCharacter.value?.spells?.get(6)?.spellChecked?.set(2,
                                view.isChecked
                            )
                            "SpellButton7-4" -> currentCharacter.value?.spells?.get(6)?.spellChecked?.set(3,
                                view.isChecked
                            )
                            "SpellButton7-5" -> currentCharacter.value?.spells?.get(6)?.spellChecked?.set(4,
                                view.isChecked
                            )
                            "SpellButton7-6" -> currentCharacter.value?.spells?.get(6)?.spellChecked?.set(5,
                                view.isChecked
                            )
                            "SpellButton7-7" -> currentCharacter.value?.spells?.get(6)?.spellChecked?.set(6,
                                view.isChecked
                            )
                            "SpellButton7-8" -> currentCharacter.value?.spells?.get(6)?.spellChecked?.set(7,
                                view.isChecked
                            )
                            "SpellButton7-9" -> currentCharacter.value?.spells?.get(6)?.spellChecked?.set(8,
                                view.isChecked
                            )
                            "SpellButton7-10" -> currentCharacter.value?.spells?.get(6)?.spellChecked?.set(9,
                                view.isChecked
                            )
                            "SpellButton7-11" -> currentCharacter.value?.spells?.get(6)?.spellChecked?.set(10,
                                view.isChecked
                            )
                            "SpellButton8-1" -> currentCharacter.value?.spells?.get(7)?.spellChecked?.set(0,
                                view.isChecked
                            )
                            "SpellButton8-2" -> currentCharacter.value?.spells?.get(7)?.spellChecked?.set(1,
                                view.isChecked
                            )
                            "SpellButton8-3" -> currentCharacter.value?.spells?.get(7)?.spellChecked?.set(2,
                                view.isChecked
                            )
                            "SpellButton8-4" -> currentCharacter.value?.spells?.get(7)?.spellChecked?.set(3,
                                view.isChecked
                            )
                            "SpellButton8-5" -> currentCharacter.value?.spells?.get(7)?.spellChecked?.set(4,
                                view.isChecked
                            )
                            "SpellButton8-6" -> currentCharacter.value?.spells?.get(7)?.spellChecked?.set(5,
                                view.isChecked
                            )
                            "SpellButton8-7" -> currentCharacter.value?.spells?.get(7)?.spellChecked?.set(6,
                                view.isChecked
                            )
                            "SpellButton8-8" -> currentCharacter.value?.spells?.get(7)?.spellChecked?.set(7,
                                view.isChecked
                            )
                            "SpellButton8-9" -> currentCharacter.value?.spells?.get(7)?.spellChecked?.set(8,
                                view.isChecked
                            )
                            "SpellButton9-1" -> currentCharacter.value?.spells?.get(8)?.spellChecked?.set(0,
                                view.isChecked
                            )
                            "SpellButton9-2" -> currentCharacter.value?.spells?.get(8)?.spellChecked?.set(1,
                                view.isChecked
                            )
                            "SpellButton9-3" -> currentCharacter.value?.spells?.get(8)?.spellChecked?.set(2,
                                view.isChecked
                            )
                            "SpellButton9-4" -> currentCharacter.value?.spells?.get(8)?.spellChecked?.set(3,
                                view.isChecked
                            )
                            "SpellButton9-5" -> currentCharacter.value?.spells?.get(8)?.spellChecked?.set(4,
                                view.isChecked
                            )
                            "SpellButton9-6" -> currentCharacter.value?.spells?.get(8)?.spellChecked?.set(5,
                                view.isChecked
                            )
                            "SpellButton9-7" -> currentCharacter.value?.spells?.get(8)?.spellChecked?.set(6,
                                view.isChecked
                            )
                            "SpellButton9-8" -> currentCharacter.value?.spells?.get(8)?.spellChecked?.set(7,
                                view.isChecked
                            )
                            "SpellButton9-9" -> currentCharacter.value?.spells?.get(8)?.spellChecked?.set(8,
                                view.isChecked
                            )
                        }
                    }
                }
            }
            is CSInspirationCheckbox -> {
                when (view.id) {
                    R.id.inspirationChecked -> currentCharacter.value?.inspiration = view.isChecked
                }
            }
        }
        saveCurrentCharacter()
    }
}

class CharacterViewModelFactory(private val application: Application): ViewModelProvider.Factory {
     override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterViewModel::class.java)) {
            return CharacterViewModel(
                application = application,
                characterUseCase = CharacterUseCase.createInstance(application.applicationContext)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}