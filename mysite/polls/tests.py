import datetime

from django.test import TestCase
from django.utils import timezone

from .models import Question

class QuestionModelTests(TestCase):
    
    # tests if was_published_recently returns false fora future question
    def test_was_published_recently_with_future_question(self):
        time = timezone.now() + datetime.timedelta(days = 30)
        future_question = Question(pub_date = time)
        # assert statement
        self.assertIs(future_question.was_published_recently(), False)

